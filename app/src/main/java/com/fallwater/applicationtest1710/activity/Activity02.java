package com.fallwater.applicationtest1710.activity;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.base.BaseActivity;
import com.fallwater.applicationtest1710.fragment.BRVAHFragment;
import com.fallwater.applicationtest1710.fragment.BitmapFragment03;
import com.fallwater.applicationtest1710.fragment.DefaultFragment;
import com.fallwater.applicationtest1710.fragment.RVFragment;
import com.fallwater.applicationtest1710.fragment.TestFragment02;
import com.fallwater.applicationtest1710.fragment.TestFragment03;
import com.fallwater.applicationtest1710.test.SparseArrayTest;
import com.fallwater.applicationtest1710.unittest.flowlayout.FlowFragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author Fallwater潘建波 on 2017/12/22
 * @mail 1667376033@qq.com
 * 功能描述:
 */
@RuntimePermissions
public class Activity02 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        addFragment();
//        testArray();
//        addBRVAHFragment();
//        addTestFragment();
//        addBitmapFragment();
        addFragment(initFragment());
    }

    private Fragment initFragment() {
//        return new DefaultFragment();
        return new TestFragment03();
    }

    /**
     * 此处添加fragment
     * @return
     */
    public Fragment create() {

        return new FlowFragment();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    /**
     * 测试BRVAH框架
     */
    private void addBRVAHFragment() {
        Fragment fragment = new BRVAHFragment();
        addFragment(fragment);
    }

    private void addTestFragment() {
        Fragment fragment = new TestFragment02();
        addFragment(fragment);
//        addFragment(create());
    }

    private void addBitmapFragment() {
        Fragment fragment = new BitmapFragment03();
        addFragment(fragment);
    }


    /**
     * 测试sparseArray
     */
    private void testArray() {
//        new SparseArrayTest().test();
        new SparseArrayTest().arrayMap();
    }

    /**
     * 测试addItemDecoration
     */
    private void addFragment() {
        Fragment fragment = new RVFragment();
        addFragment(fragment);

    }
    private void addFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_02;
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    void showCamera() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.sample_content_fragment, CameraPreviewFragment.newInstance())
//                .addToBackStack("camera")
//                .commitAllowingStateLoss();
    }
//
//    @OnShowRationale(Manifest.permission.CAMERA)
//    void showRationaleForCamera(final PermissionRequest request) {
//        new AlertDialog.Builder(this)
//                .setMessage(R.string.permission_camera_rationale)
//                .setPositiveButton(R.string.button_allow, (dialog, button) -> request.proceed())
//                .setNegativeButton(R.string.button_deny, (dialog, button) -> request.cancel())
//                .show();
//    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void showDeniedForCamera() {
//        Toast.makeText(this, R.string.permission_camera_denied, Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void showNeverAskForCamera() {
//        Toast.makeText(this, R.string.permission_camera_neverask, Toast.LENGTH_SHORT).show();
    }
}
