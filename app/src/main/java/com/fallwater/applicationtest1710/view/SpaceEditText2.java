package com.fallwater.applicationtest1710.view;

import com.fallwater.applicationtest1710.utils.StringUtil;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

/**
 * @author Fallwater潘建波 on 2018/5/4
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class SpaceEditText2 extends AppCompatEditText {

    //输入框内容改变监听
    private TextChangeListener listener;

    public SpaceEditText2(Context context) {
        super(context);
        initView(context);
    }

    public SpaceEditText2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public SpaceEditText2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context) {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
            }


            @Override
            public void afterTextChanged(Editable s) {
                deleteSpaceIfNeed();
                if (!isNeedChange(getText())) {
                    return;
                }
                //记录起始位置
                int old = getSelectionStart();
                String newContent = StringUtil.addSpeaceByCredit(s.toString());
                SpaceEditText2.this.setText(newContent);
                int newPosition = updateSelection(s.toString(), newContent, old);
                //保证光标的位置
                SpaceEditText2.this.setSelection(
                        newPosition > SpaceEditText2.this.getText().length()
                                ? SpaceEditText2.this.getText().length()
                                : newPosition);
            }
        });
    }

    private void deleteSpaceIfNeed() {
        String content = getText().toString();
        if (TextUtils.isEmpty(content)) {
            return;
        }
        int old = getSelectionStart();
        //调用setText方法会导致SelectionStart=0，过滤掉
        if (old == 0) {
            return;
        }

        if (TextUtils
                .isEmpty(content.substring(old - 1, old))) {
            String before = content.substring(0, old - 1);
            String end;
            if (old == this.length()) {
                end = "";
            } else {
                end = content.substring(old);
            }
            content = before + end;
            setText(content);
        }
    }

    private int updateSelection(String oldContent, String newContent, int old) {
        if (TextUtils.isEmpty(oldContent) | TextUtils.isEmpty(newContent)) {
            return old;
        }

        if (oldContent.length() == old) {
            return newContent.length();
        }

        if (TextUtils.isEmpty(newContent.substring(old, old + 1))) {
            return old + 1;
        }
        return old;
    }

    private boolean isNeedChange(Editable s) {
        String newContent = StringUtil.addSpeaceByCredit(s.toString());
        return !TextUtils.equals(s.toString(), newContent);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
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
