package com.fallwater.applicationtest1710.view;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.utils.StringUtil;

import android.content.Context;
import android.content.res.TypedArray;
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
public class SpaceEditText extends AppCompatEditText {

    //输入框内容改变监听
    private TextChangeListener listener;

    private int mSpace = 4;

    public SpaceEditText(Context context) {
        super(context);
        initView(context, null);
    }

    public SpaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);

    }

    public SpaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private boolean mAdd;

    private void initView(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SpaceEditText);
            mSpace = ta.getInt(R.styleable.SpaceEditText_space, 4);
            ta.recycle();
        }

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int deleteNumbers, int addNumbers) {
                mAdd = addNumbers - deleteNumbers > 0;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isNeedAddSpace(getText())) {
                    //触发回调内容
                    if (listener != null) {
                        listener.onTextChange(s.toString());
                    }
                    return;
                }
                addSpace();
            }
        });
    }

    private void addSpace() {
        String newContent = addSpaceByCredit(getText().toString(), mSpace);
        //记录起始位置
        int oldSelection = getSelectionStart();
        //调整光标的位置
        int newPosition = updateSelection(getText().toString(), newContent, oldSelection);
        SpaceEditText.this.setText(newContent);
        SpaceEditText.this.setSelection(
                newPosition > SpaceEditText.this.getText().length()
                        ? SpaceEditText.this.getText().length()
                        : newPosition);
    }

    private int updateSelection(String oldContent, String newContent, int oldSelection) {
        if (TextUtils.isEmpty(oldContent) || TextUtils.isEmpty(newContent)) {
            return oldSelection;
        }

        if (oldSelection == 0) {
            return oldSelection;
        }

        if (oldContent.length() == oldSelection) {
            return newContent.length();
        }

        //添加字符操作
        if (mAdd) {
            if (TextUtils.equals(newContent.substring(oldSelection - 1, oldSelection), " ")) {
                return oldSelection + 1;
            }
        } else {
            //删除字符操作
            if (TextUtils.equals(oldContent.substring(oldSelection - 1, oldSelection), " ")) {
                return oldSelection - 1;
            }
        }
        return oldSelection;
    }

    private boolean isNeedAddSpace(Editable s) {
        String newContent = StringUtil.addSpeaceByCredit(s.toString());
        return !TextUtils.equals(s.toString(), newContent);
    }

    /**
     * 每4位添加一个空格
     */
    public String addSpaceByCredit(String content, int space) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        content = content.replaceAll(" ", "");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i <= content.length(); i++) {
            if (i % space == 0 && i != content.length()) {
                newString.append(content.charAt(i - 1) + " ");
            } else {
                newString.append(content.charAt(i - 1));
            }
        }
        return newString.toString();
    }

    public void setTextChangeListener(TextChangeListener listener) {
        this.listener = listener;
    }

    /**
     * 输入框内容回调，当输入框内容改变时会触发
     */
    public interface TextChangeListener {

        void onTextChange(String text);
    }
}
