package com.magic.szh.cnf_168p2p.content.investment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseRegularInvestment;

import java.util.ArrayList;
import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: RegularInvestmentListAdapter
 * author: admin
 * date: 2018/2/27
 * description: 定期理财 - 数据 recycler view 适配器
 */

public class RegularInvestmentListAdapter extends RecyclerView.Adapter<RegularInvestmentListAdapter.SubjectViewHolder> {
    List<ResponseRegularInvestment.SubjectPojo> mSubjectPojoList;
    private final Context mContext;

    public RegularInvestmentListAdapter(Context context) {
        mContext = context;
        mSubjectPojoList = new ArrayList<>();
    }

    public List<ResponseRegularInvestment.SubjectPojo> getSubjectPojoList() {
        return mSubjectPojoList;
    }

    public void addDataItems(List<ResponseRegularInvestment.SubjectPojo> list) {
        int from = mSubjectPojoList.size();
        mSubjectPojoList.addAll(list);
        notifyItemRangeChanged(from, list.size());
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_regular_investment_list, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSubjectPojoList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {

        public SubjectViewHolder(View itemView) {
            super(itemView);
        }
    }
}
