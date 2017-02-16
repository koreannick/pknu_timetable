package comkoreannickpknu_timetable.github.pknu_timetable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static comkoreannickpknu_timetable.github.pknu_timetable.add_schedule.subjectAdapter;

/**
 * Created by EunYeong on 2017-02-15.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<ListData> mListData = new ArrayList<>();
    //리스트뷰에 보여질 아이템수
    @Override
    public int getCount() {
        return mListData.size();
    }

    //하나의 아이템
    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom, null, false);

            holder = new CustomViewHolder();
            holder.mTitle = (TextView) convertView.findViewById(R.id.txt_title);
            holder.mTerm = (TextView) convertView.findViewById(R.id.txt_term);
            holder.mGubun = (TextView) convertView.findViewById(R.id.txt_gubun);
            holder.mProfessor = (TextView) convertView.findViewById(R.id.txt_professor);
            holder.mClass = (TextView) convertView.findViewById(R.id.txt_class);
            holder.mGubun2 = (TextView) convertView.findViewById(R.id.txt_gubun2);
            holder.mGrade = (TextView) convertView.findViewById(R.id.txt_grade);
            holder.mTimetable = (TextView) convertView.findViewById(R.id.txt_timetable);
            holder.mTime = (TextView) convertView.findViewById(R.id.txt_time);
            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        ListData data = mListData.get(position);

        holder.mTitle.setText(data.getmTitle());
        holder.mTerm.setText(data.getmTerm());
        holder.mGubun.setText(data.getmGubun());
        holder.mProfessor.setText(data.getmProfessor());
        holder.mClass.setText(data.getmClass());
        holder.mGubun2.setText(data.getmGubun2());
        holder.mGrade.setText(data.getmGrade());
        holder.mTimetable.setText(data.getmTimetable());
        holder.mTime.setText(data.getmTime());

        return convertView;
    }
    class CustomViewHolder {
        TextView  mTitle;
        TextView mTerm;
        TextView mGubun;
        TextView mProfessor;
        TextView mClass;
        TextView mGubun2;
        TextView mGrade;
        TextView mTimetable;
        TextView mTime;
    }

    // MainActivity에서 Adapter에있는 ArrayList에 data를 추가시켜주는 함수
    public void addItem(String mTitle,String mTerm,String mGubun,String mProfessor,String mGubun2,String mClass,String mGrade,String mTimetable,String mTime){
        ListData addInfo = null;
        addInfo = new ListData();
        addInfo.mTitle = mTitle;
        addInfo.mTerm = mTerm;
        addInfo.mGubun=mGubun;
        addInfo.mProfessor=mProfessor;
        addInfo.mClass= mClass;
        addInfo.mGubun2=mGubun2;
        addInfo.mGrade=mGrade;
        addInfo.mTimetable=mTimetable;
        addInfo.mTime=mTime;

        mListData.add(addInfo);
    }

    public void dateRemove(){
        mListData.clear();
    }
    public void dataChange(){
        subjectAdapter.notifyDataSetChanged();
    }
}
