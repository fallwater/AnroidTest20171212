package com.fallwater.applicationtest1710.test;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.utils.ImageUtils;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

/**
 * @author jwb
 * @version ${VersionName}
 * @date 创建时间：2018/4/27
 * @Description：认证流程拍照示例图
 * @other 修改历史：
 */
public class PhotoSampleDialog extends AlertDialog implements View.OnClickListener {

    private String mImgUrl;

    private Context mContext;

    public PhotoSampleDialog(Context context, String imgUrl) {
        super(context, R.style.TransparentDialogStyle);
        mImgUrl = imgUrl;
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_photo_sample);
        ImageView exsampleImg = (ImageView) findViewById(R.id.dialog_sample_img);
        ImageView closeImg = (ImageView) findViewById(R.id.dialog_sample_close);
        if (!TextUtils.isEmpty(mImgUrl)) {
            ImageUtils.displayImage(mContext, exsampleImg, mImgUrl, R.mipmap.ic_launcher,R.mipmap.ic_launcher, new RequestListener() {
                @Override
                public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                    ToastUtils.showShort("onException");
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache,
                        boolean isFirstResource) {
                    ToastUtils.showShort("onResourceReady");
                    return false;
                }
            });
        }
        exsampleImg.setOnClickListener(this);
        closeImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
