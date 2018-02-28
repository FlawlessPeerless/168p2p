package com.magic.szh.cnf_168p2p.content.investment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseRegularInvestment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: RegularInvestmentListAdapter
 * author: admin
 * date: 2018/2/27
 * description: 定期理财 - 数据 recycler view 适配器
 */

public class RegularInvestmentListAdapter extends RecyclerView.Adapter<RegularInvestmentListAdapter.SubjectViewHolder> {
    private List<ResponseRegularInvestment.SubjectPojo> mSubjectPojoList;
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

    public void clearDataItems() {
        mSubjectPojoList.clear();
        notifyDataSetChanged();
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_regular_investment_list, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        holder.updateDate(mSubjectPojoList.get(position));
    }

    @Override
    public void onViewRecycled(SubjectViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return mSubjectPojoList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_subject_apr)
        TextView mSubjectApr;
        @BindView(R.id.text_view_subject_annual_yield)
        TextView mSubjectAnnual;
        @BindView(R.id.text_view_subject_name)
        TextView mSubjectName;
        @BindView(R.id.text_investment_horizon)
        TextView mTextInvestmentHorizon;
        @BindView(R.id.text_financing_amount)
        TextView mTextInvestmentFinancingAmount;
        @BindView(R.id.text_repayment_type)
        TextView mTextRepaymentType;


        public SubjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void updateDate(ResponseRegularInvestment.SubjectPojo data) {
            mSubjectName.setText(data.getName());
            if (data.getExtendRate() <= 0) {
                mSubjectApr.setVisibility(View.INVISIBLE);
            } else {
                mSubjectApr.setVisibility(View.VISIBLE);
                mSubjectApr.setText(String.format("+%s%%", data.getExtendRate()));
            }
            mSubjectAnnual.setText(String.format("%s%%", data.getBorrowApr()));
            mTextInvestmentHorizon.setText(String.format("%d个月", data.getBorrowPeriod()));
            mTextInvestmentFinancingAmount.setText(String.format("%s万元", data.getAccount() / 10000));
            mTextRepaymentType.setText(data.getStyleName());
        }
    }
}
