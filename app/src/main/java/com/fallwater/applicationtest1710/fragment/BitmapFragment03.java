package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class BitmapFragment03 extends BaseFragment {

    private static final int REQUEST_CODE_PICK_FROM_GALLEY = 1;

    private static final String TAG = "BitmapFragment03";

    private static final int M_RATE = 1024 * 1024;

    Unbinder unbinder;

    @BindView(R.id.iv_item)
    ImageView mImageView;

    @BindView(R.id.info)
    TextView infoTV;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_test03_1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.iv_item, R.id.load})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.iv_item:
                break;
            case R.id.load:
                selectFromGalley();
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if (uri != null) {
                ProcessResult(uri);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 打开手机相册
     */
    private void selectFromGalley() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE_PICK_FROM_GALLEY);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void ProcessResult(Uri destUrl) {
        String pathName = FileHelper.stripFileProtocol(destUrl.toString());
        showBitmapInfos(pathName);
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        if (bitmap != null) {
            mImageView.setImageBitmap(bitmap);
            float count = bitmap.getByteCount() / M_RATE;
            float all = bitmap.getAllocationByteCount() / M_RATE;
            String result = "这张图片占用内存大小:\n" +
                    "bitmap.getByteCount()== " + count + "M\n" +
                    "bitmap.getAllocationByteCount()= " + all + "M";
            infoTV.setText(result);
            Log.e(TAG, result);
            bitmap = null;
        } else {
//            T.showLToast(mContext, "fail");
        }
    }

    /**
     * 获取Bitmap的信息
     * @param pathName
     */
    private void showBitmapInfos(String pathName) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);
        int width = options.outWidth;
        int height = options.outHeight;

        Log.e(TAG, "showBitmapInfos: \n" +
                "width=: " + width + "\n" +
                "height=: " + height);
        options.inJustDecodeBounds = false;
    }
}
