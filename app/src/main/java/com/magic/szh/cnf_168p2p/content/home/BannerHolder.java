package com.magic.szh.cnf_168p2p.content.home;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseHomeBanner;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: BannerHolder
 * author: admin
 * date: 2018/2/23
 * description: banner 图片实现类
 */

public class BannerHolder implements Holder<ResponseHomeBanner.BannerItem> {
    private AppCompatImageView mImageView;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, ResponseHomeBanner.BannerItem data) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.banner_default_750_408);
        Glide.with(context)
                .load(data.pic)
                .apply(options)
                .into(mImageView);
    }

}
