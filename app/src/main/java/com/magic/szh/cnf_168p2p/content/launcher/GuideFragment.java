package com.magic.szh.cnf_168p2p.content.launcher;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.MagicFragment;
import com.magic.szh.cnf_168p2p.content.home.HomeActivity;
import com.magic.szh.util.storage.MagicPreference;

import java.util.ArrayList;

/**
 * A simple {@link MagicFragment} subclass.
 */
public class GuideFragment extends MagicFragment implements OnItemClickListener {
    ConvenientBanner<Integer> mConvenientBanner;
    private static final ArrayList<Integer> BANNERS = new ArrayList<>();

    private void initBanner() {
        BANNERS.clear();
        BANNERS.add(R.drawable.guide_1);
        BANNERS.add(R.drawable.guide_2);
        BANNERS.add(R.drawable.guide_3);
        BANNERS.add(R.drawable.guide_4);
        mConvenientBanner
                .setPages(new GuideHolderCreater(), BANNERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        if (position == BANNERS.size() - 1) {
            MagicPreference.setAppFlag(LauncherTag.HAS_FIRST_LAUNCHER_APP.name(), false);
            getBaseActivity().startActivity(new Intent(getActivity(), HomeActivity.class));
            getActivity().finish();
        }
    }
}
