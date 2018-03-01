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
import com.magic.szh.cnf_168p2p.api.response.ResponseRegularInvestment;
import com.magic.szh.cnf_168p2p.widget.CircleProgressBar;

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

    public void initDataItems(List<ResponseRegularInvestment.SubjectPojo> list) {
        mSubjectPojoList.clear();
        mSubjectPojoList.addAll(list);
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
        @BindView(R.id.icon_finish)
        ImageView mIconFinish;
        @BindView(R.id.circle_progress_view)
        CircleProgressBar mCircleProgressBar;


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
            mCircleProgressBar.setProgress((int) data.getBorrowAccountScale());
            setStatus(data);
        }

        /**
         * 设置item状态
         * @param data 数据
         */
        private void setStatus(ResponseRegularInvestment.SubjectPojo data) {
            String status = data.getStatusName();
            boolean hasRedBagIcon = data.getRedbagStatus() == 1;
            boolean hasVoucherIcon = data.getVoucherStatus() == 1;

            switch (status) {
                case "preset":
                    // 即将开始
                case "loan":
                    // 立即投资
                    setTitleOverIcon(hasRedBagIcon, hasVoucherIcon);
                    mIconFinish.setVisibility(View.GONE);
                    mCircleProgressBar.setVisibility(View.VISIBLE);
                    break;
                case "over":
                    // 抢光了
                    setTitleIcon(hasRedBagIcon, hasVoucherIcon);
                    mIconFinish.setVisibility(View.VISIBLE);
                    mIconFinish.setBackgroundResource(R.drawable.investment_project_over_new);
                    mCircleProgressBar.setVisibility(View.GONE);
                    break;
                case "repay_over":
                    // 已还完
                    setTitleIcon(hasRedBagIcon, hasVoucherIcon);
                    mIconFinish.setVisibility(View.GONE);
                    mCircleProgressBar.setVisibility(View.GONE);
                    break;
                case "repay":
                    // 还款中
                    setTitleIcon(hasRedBagIcon, hasVoucherIcon);
                    mIconFinish.setVisibility(View.VISIBLE);
                    mIconFinish.setBackgroundResource(R.drawable.investment_project_repay_new);
                    mCircleProgressBar.setVisibility(View.GONE);
                    break;
            }
        }

        /**
         * 设置进行中图标
         * @param redBag 是否显示红包
         * @param voucher 是否显示现金券
         */
        private void setTitleIcon(boolean redBag, boolean voucher){
            if (redBag && voucher) {
                mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_redbag_voucher_new,0);
            } else {
                if (redBag) {
                    mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_redbag_new, 0);
                }
                if (voucher) {
                    mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_voucher_new, 0);
                }
            }
        }

        /**
         * 设置结束图标
         * @param redBag 是否显示红包
         * @param voucher 是否显示现金券
         */
        private void setTitleOverIcon(boolean redBag, boolean voucher) {
            if (redBag && voucher) {
                mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_redbag_voucher_new_gray,0);
            } else {
                if (redBag) {
                    mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_redbag_new_gray, 0);
                }
                if (voucher) {
                    mSubjectName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.investment_project_redbag_voucher_new_gray, 0);
                }
            }
        }

        /**
         * 设置当前item 文字状态
         * @param isFinish boolean 是否完成
         */
        private void setSubjectValueStatus(boolean isFinish) {
            if (isFinish) {
                mSubjectApr.setBackgroundResource(R.drawable.bg_annual_yield_gray);
                mSubjectAnnual.setTextColor(Color.parseColor("#f65b66"));
            } else {
                mSubjectApr.setBackgroundResource(R.drawable.bg_annual_yield_red);
                mSubjectAnnual.setTextColor(Color.parseColor("#333333"));
            }
        }
    }
}
