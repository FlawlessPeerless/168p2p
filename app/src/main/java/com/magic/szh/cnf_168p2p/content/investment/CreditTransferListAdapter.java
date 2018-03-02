package com.magic.szh.cnf_168p2p.content.investment;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseTransferInvestment;
import com.magic.szh.cnf_168p2p.widget.CircleProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: CreditTransferListAdapter
 * author: admin
 * date: 2018/3/2
 * description: 债权转让列表 适配器
 */

public class CreditTransferListAdapter extends RecyclerView.Adapter<CreditTransferListAdapter.SubjectViewHolder> {
    private Context mContext;
    // 数据
    private List<ResponseTransferInvestment.SubjectPojo> mList;

    public CreditTransferListAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_transfer_investment_list, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        holder.updateData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void initData(List<ResponseTransferInvestment.SubjectPojo> data) {
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(List<ResponseTransferInvestment.SubjectPojo> data) {
        int from = mList.size();
        mList.addAll(data);
        notifyItemRangeInserted(from, data.size());

    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.icon_finish)
        ImageView mIconFinish;
        @BindView(R.id.circle_progress_view)
        CircleProgressBar mCircleProgressBar;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void updateData(ResponseTransferInvestment.SubjectPojo data) {
            mSubjectName.setText(data.getName());
            mSubjectAnnual.setText(String.format("%s%%", data.getBorrowApr()));
            mTextInvestmentHorizon.setText(String.format("%s元", data.getTenderAccount()));
            // 剩余期限
            mTextInvestmentFinancingAmount.setText(String.format("%d个月%d天", data.getMonth(), data.getDay()));
            // 可投金额
            mTextRepaymentType.setText(String.format("%s元", data.getBorrowAccountWait()));
            // 进度条
            mCircleProgressBar.setProgress((int) data.getBorrowAccountScale());
            // 设置状态
            setStatus(data);
        }

        /**
         * 设置item 状态
         * @param data 数据实体
         */
        private void setStatus(ResponseTransferInvestment.SubjectPojo data) {
            String status = data.getStatusName();
            switch (status) {
                case "loan":
                    // 立即投资
                    setPercentTextColor(true);
                    setIconStatus(true);
                    break;
                case "over":
                    // 抢光了
                case "repay_over":
                    // 已转让
                    setPercentTextColor(false);
                    setIconStatus(false);
                    break;
                default:
            }
        }

        private void setPercentTextColor(boolean isFocus) {
            if (isFocus) {
                // 选中
                mSubjectAnnual.setTextColor(Color.parseColor("#f65b66"));
            } else {
                mSubjectAnnual.setTextColor(Color.parseColor("#333333"));
            }
        }

        private void setIconStatus(boolean isFocus) {
            if (isFocus) {
                mCircleProgressBar.setVisibility(View.VISIBLE);
                mIconFinish.setVisibility(View.GONE);
            } else {
                mCircleProgressBar.setVisibility(View.GONE);
                mIconFinish.setVisibility(View.VISIBLE);
            }
        }
    }
}
