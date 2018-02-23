package com.magic.szh.cnf_168p2p.content.home;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: BannerHolderCreator
 * author: admin
 * date: 2018/2/23
 * description:
 */

public class BannerHolderCreator implements CBViewHolderCreator<BannerHolder> {
    @Override
    public BannerHolder createHolder() {
        return new BannerHolder();
    }
}
