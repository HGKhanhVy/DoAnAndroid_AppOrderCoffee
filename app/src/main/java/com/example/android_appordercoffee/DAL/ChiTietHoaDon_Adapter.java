package com.example.android_appordercoffee.DAL;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_appordercoffee.GUI.ChiTietHoaDonActivity;
import com.example.android_appordercoffee.R;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChiTietHoaDon_Adapter  extends BaseAdapter {
    private Activity activiti;
    SQLiteHelper db ;
    private  ArrayList<CT_HoaDon_DTO> list ;
    public ChiTietHoaDon_Adapter(Activity activity, ArrayList<CT_HoaDon_DTO> arrayList){
        this.activiti = activity;
        this.list = arrayList;
        db= new SQLiteHelper(activity);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //laay  view ra sài
        LayoutInflater inflater = activiti.getLayoutInflater();
        view =inflater.inflate(R.layout.listview_ct_hoadon,null);

        //đưa dữ liệu vào view
        //mã hóa đơn, mã sản phẩm , tên sản phẩm , số lượng, đơn giá , thành tiền
        TextView txt_TenSanPham =(TextView) view.findViewById(R.id.txtTenSP);
        TextView txt_DonGia =(TextView) view.findViewById(R.id.txtDonGia);
        TextView txt_SoLuong =(TextView) view.findViewById(R.id.txtSL);
        TextView txt_ThanhTien =(TextView) view.findViewById(R.id.txtThanhTien);
        Button btnThem = (Button) view.findViewById(R.id.btnThem);
        Button btnXoa = (Button) view.findViewById(R.id.btnXoa);

        //lấy môt người trong list ra
        CT_HoaDon_DTO items = list.get(i);
        txt_TenSanPham.setText(items.getTenNuoc());
        txt_DonGia.setText(String.valueOf(items.getDonGia()));
        txt_SoLuong.setText(String.valueOf(items.getSoLuong()));
        txt_ThanhTien.setText(ThemDauCham((int)items.getThanhTien()));
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.valueOf(txt_SoLuong.getText().toString())+1;
                float thanhtien =sl* items.getDonGia();
                CT_HoaDon_DTO ct = new CT_HoaDon_DTO(items.getMaHoaDon(), items.getMaNuoc(), items.getTenNuoc(),sl,items.getDonGia(), thanhtien);
                int kt = db.capNhatSLThucUong(ct);
               if(kt ==1){
                   txt_SoLuong.setText(String.valueOf(sl));
                   Toast.makeText(activiti,"Thành Công", Toast.LENGTH_LONG).show();
               }
                txt_ThanhTien.setText(ThemDauCham((int)thanhtien)+"đ");
                reloadMyActivity();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.valueOf(txt_SoLuong.getText().toString())-1;
                float thanhtien =sl* items.getDonGia();
                reloadMyActivity();
                if(sl  ==0){
                    //xóa khỏi chi tiết hóa đơn
                    String _maHD = items.getMaHoaDon();
                    String _maSP = items.getMaNuoc();
                    if( db.DeleteCTHoaDon(_maSP, _maHD)==1){
                        Toast.makeText(activiti,"Thành Công", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(activiti,"Cập nhật về 0 thất bại", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    CT_HoaDon_DTO ct = new CT_HoaDon_DTO(items.getMaHoaDon(), items.getMaNuoc(), items.getTenNuoc(),sl,items.getDonGia(), thanhtien);
                    int kt = db.capNhatSLThucUong(ct);
                    if(kt ==1){
                        txt_SoLuong.setText(String.valueOf(sl));
                        Toast.makeText(activiti,"Thành Công", Toast.LENGTH_LONG).show();
                    }
                    txt_ThanhTien.setText(ThemDauCham((int)thanhtien)+"đ");
                }
                reloadMyActivity();
            }
        });
        return view;
    }
    public void reloadMyActivity() {
        Intent intent = new Intent(activiti, ChiTietHoaDonActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activiti.startActivity(intent);
    }
    public String ThemDauCham(int tien){
        double amount = (double)tien;
        DecimalFormat formatter = new DecimalFormat("#,##0");
        return formatter.format(amount);
    }
}
