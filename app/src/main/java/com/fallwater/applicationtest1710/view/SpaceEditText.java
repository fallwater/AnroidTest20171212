package com.fallwater.applicationtest1710.view;

import com.fallwater.applicationtest1710.utils.StringUtil;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

/**
 * @author Fallwater潘建波 on 2018/5/4
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class SpaceEditText extends AppCompatEditText {

    private final static String TAG = "SpaceEditText";


    //上次输入框中的内容
    private String lastString;

    //光标的位置
    private int selectPosition;

    //输入框内容改变监听
    private TextChangeListener listener;

    private boolean mBooleanTextChange;


    public SpaceEditText(Context context) {
        super(context);
        initView(context);
    }

    public SpaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public SpaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context) {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged");
                mBooleanTextChange = true;
            }


            /**
             * 当输入框内容改变时的回调
             * @param s  改变后的字符串
             * @param start 改变之后的光标下标
             * @param deleteNumbers 删除了多少个字符
             * @param addNumbers 添加了多少个字符
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int deleteNumbers, int addNumbers) {
                Log.d(TAG, "onTextChanged,start:" + start + ",deleteNumbers:" + deleteNumbers + ",addNumbers:"
                        + addNumbers);

                //因为重新排序之后setText的存在
                //会导致输入框的内容从0开始输入，这里是为了避免这种情况产生一系列问题
                int add = addNumbers - deleteNumbers;
                if (start == 0 && add >= 1) {
                    selectPosition = addNumbers;
                    return;
                }

                String textTrim = StringUtil.getTextTrim(SpaceEditText.this);
                //add < 0,代表此次操作是删除操作
                if (add < 0) {
                    selectPosition = start;
                    if (TextUtils.isEmpty(lastString)) {
                        return;
                    }
                    //将上次的字符串去空格 和 改变之后的字符串去空格 进行比较
                    //如果一致，代表本次操作删除的是空格
                    if (textTrim.equals(lastString.replaceAll(" ", ""))) {
                        //帮助用户删除该删除的字符，而不是空格
                        StringBuffer stringBuffer = new StringBuffer(lastString);
                        stringBuffer.deleteCharAt(start - 1);
                        selectPosition = start - 1;
                        SpaceEditText.this.setText(stringBuffer.toString());
                    }
                } else {
                    //此处代表是添加操作
                    //当光标位于空格之前，添加字符时，需要让光标跳过空格，再按照之前的逻辑计算光标位置
                    //第一次空格出现的位置是4，第二次是4+1(空格)+4=9，第三次是4+1(空格)+4+1(空格)+4=14
                    //如果按照数学公式，则当start = 5n-1时，需要让光标跳过空格
                    //也就是当stat%5 == 4时
                    if (start % 5 == 4) {
                        selectPosition = start + add + 1;
                    } else {
                        selectPosition = start + add;
                    }
                }

                Log.d(TAG, "onTextChanged,selectPosition:" + selectPosition);
            }


            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged,Editable:" + s.toString());
                //获取输入框中的内容,不可以去空格
                String etContent = StringUtil.getText(SpaceEditText.this);
                if (TextUtils.isEmpty(etContent)) {
                    if (listener != null) {
                        listener.textChange("");
                    }
                    return;
                }
                //重新拼接字符串
                String newContent = StringUtil.addSpeaceByCredit(etContent);
                //保存本次字符串数据
                lastString = newContent;

                //如果有改变，则重新填充
                //防止EditText无限setText()产生死循环
                if (!newContent.equals(etContent)) {
                    SpaceEditText.this.setText(newContent);
                    //保证光标的位置
                    SpaceEditText.this.setSelection(
                            selectPosition > SpaceEditText.this.getText().length()
                                    ? SpaceEditText.this.getText().length()
                                    : selectPosition);
                }
                //触发回调内容
                if (listener != null) {
                    listener.textChange(newContent);
                }

            }
        });
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (!mBooleanTextChange) {
            selectPosition = selStart;
        }
        resetFlag();
        Log.d(TAG, "onSelectionChanged:selectPosition:" + selectPosition);
    }

    private void resetFlag() {
        mBooleanTextChange = false;
    }

    public void setTextChangeListener(TextChangeListener listener) {
        this.listener = listener;
    }

    /**
     * 输入框内容回调，当输入框内容改变时会触发
     */
    public interface TextChangeListener {

        void textChange(String text);
    }
}
