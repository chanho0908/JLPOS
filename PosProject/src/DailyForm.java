
import DTO.OrderDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


public class DailyForm extends javax.swing.JFrame {
    ArrayList<JButton> dayButtons;

    public DailyForm() {
        initComponents();
        btnExit.setFocusPainted(false);
        setResizable(false);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        jLabel3.setHorizontalAlignment(JLabel.CENTER);
        jLabel4.setHorizontalAlignment(JLabel.CENTER);
        jLabel5.setHorizontalAlignment(JLabel.CENTER);
        jLabel6.setHorizontalAlignment(JLabel.CENTER);
        jLabel7.setHorizontalAlignment(JLabel.CENTER);
        
        // DB에서 where 절에서 일별로 Data를 가져와 label에 set
        if(getMonthlySales("2022-01-01%") != null){
            day1.setText(day1.getText() + getMonthlySales("2022-01-01%") + "원");
        }else {
            day1.setText(day1.getText() + "0 원");
        }
        
        if(getMonthlySales("2022-01-02%") != null){
            day2.setText(day2.getText() + getMonthlySales("2022-01-02%") + "원");
        }else {
            day2.setText(day2.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-03%") != null){
            day3.setText(day3.getText() + getMonthlySales("2022-01-03%") + "원");
        }else {
            day3.setText(day3.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-04%") != null){
            day4.setText(day4.getText() + getMonthlySales("2022-01-04%") + "원");
        }else {
            day4.setText(day4.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-05%") != null){
            day5.setText(day5.getText() + getMonthlySales("2022-01-05%") + "원");
        }else {
            day5.setText(day5.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-06%") != null){
            day6.setText(day6.getText() + getMonthlySales("2022-01-06%") + "원");
        }else {
            day6.setText(day6.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-07%") != null){
            day7.setText(day7.getText() + getMonthlySales("2022-01-07%") + "원");
        }else {
            day7.setText(day7.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-08%") != null){
            day8.setText(day8.getText() + getMonthlySales("2022-01-08%") + "원");
        }else {
            day8.setText(day8.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-09%") != null){
            day9.setText(day9.getText() + getMonthlySales("2022-01-09%") + "원");
        }else {
            day9.setText(day9.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-10%") != null){
            day10.setText(day10.getText() + getMonthlySales("2022-01-10%") + "원");
        }else {
            day10.setText(day10.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-11%") != null){
            day11.setText(day11.getText() + getMonthlySales("2022-01-11%") + "원");
        }else {
            day11.setText(day11.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-12%") != null){
            day12.setText(day12.getText() + getMonthlySales("2022-01-12%") + "원");
        }else {
            day12.setText(day12.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-13%") != null){
            day13.setText(day13.getText() + getMonthlySales("2022-01-13%") + "원");
        }else {
            day13.setText(day13.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-14%") != null){
            day14.setText(day14.getText() + getMonthlySales("2022-01-14%") + "원");
        }else {
            day14.setText(day14.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-15%") != null){
            day15.setText(day15.getText() + getMonthlySales("2022-01-15%") + "원");
        }else {
            day15.setText(day15.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-16%") != null){
            day16.setText(day16.getText() + getMonthlySales("2022-01-16%") + "원");
        }else {
            day16.setText(day16.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-17%") != null){
            day17.setText(day17.getText() + getMonthlySales("2022-01-17%") + "원");
        }else {
            day17.setText(day17.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-18%") != null){
            day18.setText(day18.getText() + getMonthlySales("2022-01-18%") + "원");
        }else {
            day18.setText(day18.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-19%") != null){
            day19.setText(day19.getText() + getMonthlySales("2022-01-19%") + "원");
        }else {
            day19.setText(day19.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-20%") != null){
            day20.setText(day20.getText() + getMonthlySales("2022-01-20%") + "원");
        }else {
            day20.setText(day20.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-21%") != null){
            day21.setText(day21.getText() + getMonthlySales("2022-01-21%") + "원");
        }else {
            day21.setText(day21.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-22%") != null){
            day22.setText(day22.getText() + getMonthlySales("2022-01-22%") + "원");
        }else {
            day22.setText(day22.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-23%") != null){
            day23.setText(day23.getText() + getMonthlySales("2022-01-23%") + "원");
        }else {
            day23.setText(day23.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-24%") != null){
            day24.setText(day24.getText() + getMonthlySales("2022-01-24%") + "원");
        }else {
            day24.setText(day24.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-25%") != null){
            day25.setText(day25.getText() + getMonthlySales("2022-01-25%") + "원");
        }else {
            day25.setText(day25.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-26%") != null){
            day26.setText(day26.getText() + getMonthlySales("2022-01-26%") + "원");
        }else {
            day26.setText(day26.getText() + " 0 원");
        }
        if(getMonthlySales("2022-01-27%") != null){
            day27.setText(day27.getText() + getMonthlySales("2022-01-27%") + "원");
        }else {
            day27.setText(day27.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-28%") != null){
            day28.setText(day28.getText() + getMonthlySales("2022-01-28%") + "원");
        }else {
            day28.setText(day28.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-29%") != null){
            day29.setText(day29.getText() + getMonthlySales("2022-01-29%") + "원");
        }else {
            day29.setText(day29.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-30%") != null){
            day30.setText(day30.getText() + getMonthlySales("2022-01-30%") + "원");
        }else {
            day30.setText(day30.getText() + " 0 원");
        }
        
        if(getMonthlySales("2022-01-31%") != null){
            day31.setText(day31.getText() + getMonthlySales("2022-01-30%") + "원");
        }else {
            day31.setText(day31.getText() + " 0 원");
        }
        
        dayButtons = new ArrayList<>();
        
        addDayButtons();
        
        
    }
    
    public void addDayButtons(){
        dayButtons.add(day1);
        dayButtons.add(day2);
        dayButtons.add(day3);
        dayButtons.add(day4);
        dayButtons.add(day5);
        dayButtons.add(day6);
        dayButtons.add(day7);
        dayButtons.add(day8);
        dayButtons.add(day9);
        dayButtons.add(day10);
        dayButtons.add(day11);
        dayButtons.add(day12);
        dayButtons.add(day13);
        dayButtons.add(day14);
        dayButtons.add(day15);
        dayButtons.add(day16);
        dayButtons.add(day17);
        dayButtons.add(day18);
        dayButtons.add(day19);
        dayButtons.add(day20);
        dayButtons.add(day21);
        dayButtons.add(day22);
        dayButtons.add(day23);
        dayButtons.add(day24);
        dayButtons.add(day25);
        dayButtons.add(day26);
        dayButtons.add(day27);
        dayButtons.add(day28);
        dayButtons.add(day29);
        dayButtons.add(day30);
        dayButtons.add(day31);
        
                
        for(JButton d : dayButtons){
            d.setFocusPainted(false);
            d.addActionListener(new buttonActionListener());
        }
    }
    
     // 전체 매출을 저장하는 Table 에서 월별, 일별로 select 한 총 매출 값 반환
    public String getMonthlySales(String m){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "";
        String SQL = "select sum(totalPrice) from daily_order_result where reg like ?" ;
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,m);
            rs = pstmt.executeQuery();
            System.out.println("");
            if(rs.next()){
                result = rs.getString(1);
                return result;
            }
        }catch(Exception e) {e.printStackTrace();
        }finally{
            try{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            }catch(Exception e){e.printStackTrace();}
        }
        return result;        
    }
    
    // 전체 매출을 저장하는 Table 에서 월별, 일별로 select 한 총 수량 값 반환
    public String getMonthlyCount(String m){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "";
        String SQL = "select sum(productCount) from daily_order_result where reg like ?" ;
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,m);
            rs = pstmt.executeQuery();
            System.out.println("");
            if(rs.next()){
                result = rs.getString(1);
                return result;
            }
        }catch(Exception e) {e.printStackTrace();
        }finally{
            try{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            }catch(Exception e){e.printStackTrace();}
        }
        return result;        
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        d7 = new javax.swing.JButton();
        day2 = new javax.swing.JButton();
        day3 = new javax.swing.JButton();
        d8 = new javax.swing.JButton();
        d9 = new javax.swing.JButton();
        day4 = new javax.swing.JButton();
        day5 = new javax.swing.JButton();
        d10 = new javax.swing.JButton();
        day6 = new javax.swing.JButton();
        d11 = new javax.swing.JButton();
        day7 = new javax.swing.JButton();
        d12 = new javax.swing.JButton();
        day8 = new javax.swing.JButton();
        d13 = new javax.swing.JButton();
        d14 = new javax.swing.JButton();
        day9 = new javax.swing.JButton();
        d21 = new javax.swing.JButton();
        day16 = new javax.swing.JButton();
        d20 = new javax.swing.JButton();
        day15 = new javax.swing.JButton();
        d19 = new javax.swing.JButton();
        day14 = new javax.swing.JButton();
        d18 = new javax.swing.JButton();
        day13 = new javax.swing.JButton();
        d17 = new javax.swing.JButton();
        day12 = new javax.swing.JButton();
        d16 = new javax.swing.JButton();
        day11 = new javax.swing.JButton();
        d15 = new javax.swing.JButton();
        day10 = new javax.swing.JButton();
        d24 = new javax.swing.JButton();
        d23 = new javax.swing.JButton();
        d28 = new javax.swing.JButton();
        d25 = new javax.swing.JButton();
        day23 = new javax.swing.JButton();
        d27 = new javax.swing.JButton();
        d22 = new javax.swing.JButton();
        day22 = new javax.swing.JButton();
        day20 = new javax.swing.JButton();
        day21 = new javax.swing.JButton();
        day19 = new javax.swing.JButton();
        day17 = new javax.swing.JButton();
        d26 = new javax.swing.JButton();
        day18 = new javax.swing.JButton();
        d29 = new javax.swing.JButton();
        d30 = new javax.swing.JButton();
        day24 = new javax.swing.JButton();
        day25 = new javax.swing.JButton();
        d31 = new javax.swing.JButton();
        day26 = new javax.swing.JButton();
        d32 = new javax.swing.JButton();
        day27 = new javax.swing.JButton();
        d33 = new javax.swing.JButton();
        day28 = new javax.swing.JButton();
        day = new javax.swing.JButton();
        day29 = new javax.swing.JButton();
        d35 = new javax.swing.JButton();
        day30 = new javax.swing.JButton();
        c = new javax.swing.JButton();
        day1 = new javax.swing.JButton();
        d36 = new javax.swing.JButton();
        day31 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("맑은 고딕", 1, 38)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        txtTitle.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        txtTitle.setText("2022년 1월 매출 현황");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        d7.setBackground(new java.awt.Color(102, 102, 102));
        d7.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d7.setForeground(new java.awt.Color(255, 255, 255));
        d7.setText("2");
        d7.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day2.setBackground(new java.awt.Color(102, 102, 102));
        day2.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day2.setForeground(new java.awt.Color(255, 255, 255));
        day2.setText("  매출 :");
        day2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day3.setBackground(new java.awt.Color(102, 102, 102));
        day3.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day3.setForeground(new java.awt.Color(255, 255, 255));
        day3.setText("  매출 :");
        day3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d8.setBackground(new java.awt.Color(102, 102, 102));
        d8.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d8.setForeground(new java.awt.Color(255, 255, 255));
        d8.setText("3");
        d8.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d9.setBackground(new java.awt.Color(102, 102, 102));
        d9.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d9.setForeground(new java.awt.Color(255, 255, 255));
        d9.setText("4");
        d9.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day4.setBackground(new java.awt.Color(102, 102, 102));
        day4.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day4.setForeground(new java.awt.Color(255, 255, 255));
        day4.setText("  매출 :");
        day4.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day5.setBackground(new java.awt.Color(102, 102, 102));
        day5.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day5.setForeground(new java.awt.Color(255, 255, 255));
        day5.setText("  매출 :");
        day5.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d10.setBackground(new java.awt.Color(102, 102, 102));
        d10.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d10.setForeground(new java.awt.Color(255, 255, 255));
        d10.setText("5");
        d10.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day6.setBackground(new java.awt.Color(102, 102, 102));
        day6.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day6.setForeground(new java.awt.Color(255, 255, 255));
        day6.setText("  매출 :");
        day6.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d11.setBackground(new java.awt.Color(102, 102, 102));
        d11.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d11.setForeground(new java.awt.Color(255, 255, 255));
        d11.setText("6");
        d11.setToolTipText("");
        d11.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day7.setBackground(new java.awt.Color(102, 102, 102));
        day7.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day7.setForeground(new java.awt.Color(255, 255, 255));
        day7.setText("  매출 :");
        day7.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d12.setBackground(new java.awt.Color(102, 102, 102));
        d12.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d12.setForeground(new java.awt.Color(255, 255, 255));
        d12.setText("7");
        d12.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day8.setBackground(new java.awt.Color(102, 102, 102));
        day8.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day8.setForeground(new java.awt.Color(255, 255, 255));
        day8.setText("  매출 :");
        day8.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d13.setBackground(new java.awt.Color(102, 102, 102));
        d13.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d13.setForeground(new java.awt.Color(255, 255, 255));
        d13.setText("8");
        d13.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d14.setBackground(new java.awt.Color(102, 102, 102));
        d14.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d14.setForeground(new java.awt.Color(255, 255, 255));
        d14.setText("9");
        d14.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day9.setBackground(new java.awt.Color(102, 102, 102));
        day9.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day9.setForeground(new java.awt.Color(255, 255, 255));
        day9.setText("  매출 :");
        day9.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d21.setBackground(new java.awt.Color(102, 102, 102));
        d21.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d21.setForeground(new java.awt.Color(255, 255, 255));
        d21.setText("16");
        d21.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day16.setBackground(new java.awt.Color(102, 102, 102));
        day16.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day16.setForeground(new java.awt.Color(255, 255, 255));
        day16.setText("  매출 :");
        day16.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d20.setBackground(new java.awt.Color(102, 102, 102));
        d20.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d20.setForeground(new java.awt.Color(255, 255, 255));
        d20.setText("15");
        d20.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day15.setBackground(new java.awt.Color(102, 102, 102));
        day15.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day15.setForeground(new java.awt.Color(255, 255, 255));
        day15.setText("  매출 :");
        day15.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d19.setBackground(new java.awt.Color(102, 102, 102));
        d19.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d19.setForeground(new java.awt.Color(255, 255, 255));
        d19.setText("14");
        d19.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day14.setBackground(new java.awt.Color(102, 102, 102));
        day14.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day14.setForeground(new java.awt.Color(255, 255, 255));
        day14.setText("  매출 :");
        day14.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d18.setBackground(new java.awt.Color(102, 102, 102));
        d18.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d18.setForeground(new java.awt.Color(255, 255, 255));
        d18.setText("13");
        d18.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day13.setBackground(new java.awt.Color(102, 102, 102));
        day13.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day13.setForeground(new java.awt.Color(255, 255, 255));
        day13.setText("  매출 :");
        day13.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d17.setBackground(new java.awt.Color(102, 102, 102));
        d17.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d17.setForeground(new java.awt.Color(255, 255, 255));
        d17.setText("12");
        d17.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day12.setBackground(new java.awt.Color(102, 102, 102));
        day12.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day12.setForeground(new java.awt.Color(255, 255, 255));
        day12.setText("  매출 :");
        day12.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d16.setBackground(new java.awt.Color(102, 102, 102));
        d16.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d16.setForeground(new java.awt.Color(255, 255, 255));
        d16.setText("11");
        d16.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day11.setBackground(new java.awt.Color(102, 102, 102));
        day11.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day11.setForeground(new java.awt.Color(255, 255, 255));
        day11.setText("  매출 :");
        day11.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d15.setBackground(new java.awt.Color(102, 102, 102));
        d15.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d15.setForeground(new java.awt.Color(255, 255, 255));
        d15.setText("10");
        d15.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day10.setBackground(new java.awt.Color(102, 102, 102));
        day10.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day10.setForeground(new java.awt.Color(255, 255, 255));
        day10.setText("  매출 :");
        day10.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d24.setBackground(new java.awt.Color(102, 102, 102));
        d24.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d24.setForeground(new java.awt.Color(255, 255, 255));
        d24.setText("19");
        d24.setToolTipText("");
        d24.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d23.setBackground(new java.awt.Color(102, 102, 102));
        d23.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d23.setForeground(new java.awt.Color(255, 255, 255));
        d23.setText("18");
        d23.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d28.setBackground(new java.awt.Color(102, 102, 102));
        d28.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d28.setForeground(new java.awt.Color(255, 255, 255));
        d28.setText("23");
        d28.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d25.setBackground(new java.awt.Color(102, 102, 102));
        d25.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d25.setForeground(new java.awt.Color(255, 255, 255));
        d25.setText("20");
        d25.setToolTipText("");
        d25.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day23.setBackground(new java.awt.Color(102, 102, 102));
        day23.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day23.setForeground(new java.awt.Color(255, 255, 255));
        day23.setText("  매출 :");
        day23.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d27.setBackground(new java.awt.Color(102, 102, 102));
        d27.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d27.setForeground(new java.awt.Color(255, 255, 255));
        d27.setText("22");
        d27.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d22.setBackground(new java.awt.Color(102, 102, 102));
        d22.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d22.setForeground(new java.awt.Color(255, 255, 255));
        d22.setText("17");
        d22.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day22.setBackground(new java.awt.Color(102, 102, 102));
        day22.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day22.setForeground(new java.awt.Color(255, 255, 255));
        day22.setText("  매출 :");
        day22.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day20.setBackground(new java.awt.Color(102, 102, 102));
        day20.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day20.setForeground(new java.awt.Color(255, 255, 255));
        day20.setText("  매출 :");
        day20.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day21.setBackground(new java.awt.Color(102, 102, 102));
        day21.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day21.setForeground(new java.awt.Color(255, 255, 255));
        day21.setText("  매출 :");
        day21.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day19.setBackground(new java.awt.Color(102, 102, 102));
        day19.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day19.setForeground(new java.awt.Color(255, 255, 255));
        day19.setText("  매출 :");
        day19.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day17.setBackground(new java.awt.Color(102, 102, 102));
        day17.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day17.setForeground(new java.awt.Color(255, 255, 255));
        day17.setText("  매출 :");
        day17.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d26.setBackground(new java.awt.Color(102, 102, 102));
        d26.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d26.setForeground(new java.awt.Color(255, 255, 255));
        d26.setText("21");
        d26.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day18.setBackground(new java.awt.Color(102, 102, 102));
        day18.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day18.setForeground(new java.awt.Color(255, 255, 255));
        day18.setText("  매출 :");
        day18.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d29.setBackground(new java.awt.Color(102, 102, 102));
        d29.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d29.setForeground(new java.awt.Color(255, 255, 255));
        d29.setText("24");
        d29.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        d30.setBackground(new java.awt.Color(102, 102, 102));
        d30.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d30.setForeground(new java.awt.Color(255, 255, 255));
        d30.setText("25");
        d30.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day24.setBackground(new java.awt.Color(102, 102, 102));
        day24.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day24.setForeground(new java.awt.Color(255, 255, 255));
        day24.setText("  매출 :");
        day24.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day25.setBackground(new java.awt.Color(102, 102, 102));
        day25.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day25.setForeground(new java.awt.Color(255, 255, 255));
        day25.setText("  매출 :");
        day25.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d31.setBackground(new java.awt.Color(102, 102, 102));
        d31.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d31.setForeground(new java.awt.Color(255, 255, 255));
        d31.setText("26");
        d31.setToolTipText("");
        d31.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day26.setBackground(new java.awt.Color(102, 102, 102));
        day26.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day26.setForeground(new java.awt.Color(255, 255, 255));
        day26.setText("  매출 :");
        day26.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d32.setBackground(new java.awt.Color(102, 102, 102));
        d32.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d32.setForeground(new java.awt.Color(255, 255, 255));
        d32.setText("27");
        d32.setToolTipText("");
        d32.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day27.setBackground(new java.awt.Color(102, 102, 102));
        day27.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day27.setForeground(new java.awt.Color(255, 255, 255));
        day27.setText("  매출 :");
        day27.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d33.setBackground(new java.awt.Color(102, 102, 102));
        d33.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d33.setForeground(new java.awt.Color(255, 255, 255));
        d33.setText("28");
        d33.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day28.setBackground(new java.awt.Color(102, 102, 102));
        day28.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day28.setForeground(new java.awt.Color(255, 255, 255));
        day28.setText("  매출 :");
        day28.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        day.setBackground(new java.awt.Color(102, 102, 102));
        day.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        day.setForeground(new java.awt.Color(255, 255, 255));
        day.setText("29");
        day.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day29.setBackground(new java.awt.Color(102, 102, 102));
        day29.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day29.setForeground(new java.awt.Color(255, 255, 255));
        day29.setText("  매출 :");
        day29.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d35.setBackground(new java.awt.Color(102, 102, 102));
        d35.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d35.setForeground(new java.awt.Color(255, 255, 255));
        d35.setText("30");
        d35.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day30.setBackground(new java.awt.Color(102, 102, 102));
        day30.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day30.setForeground(new java.awt.Color(255, 255, 255));
        day30.setText("  매출 :");
        day30.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        c.setBackground(new java.awt.Color(102, 102, 102));
        c.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        c.setForeground(new java.awt.Color(255, 255, 255));
        c.setText("1");
        c.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        c.setBorderPainted(false);

        day1.setBackground(new java.awt.Color(102, 102, 102));
        day1.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day1.setForeground(new java.awt.Color(255, 255, 255));
        day1.setText("  매출 :");
        day1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        d36.setBackground(new java.awt.Color(102, 102, 102));
        d36.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        d36.setForeground(new java.awt.Color(255, 255, 255));
        d36.setText("31");
        d36.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        day31.setBackground(new java.awt.Color(102, 102, 102));
        day31.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        day31.setForeground(new java.awt.Color(255, 255, 255));
        day31.setText("  매출 :");
        day31.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        day31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("수");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("화");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("월");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("일");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("토");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("금");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("목");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(day6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(d11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(d12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(day8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(day9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day31, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d36, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d31, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d32, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day28, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d33, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(d35, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(d28, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(day15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(d21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(day16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(d33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(day28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(d36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(day31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        MonthlySalesForm ms  = new MonthlySalesForm();
        ms.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    public ArrayList<OrderDTO> getOderList(String date){
      ArrayList<OrderDTO> orderList = new ArrayList<>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try{
          conn = DBconnection.getConnection();

          String SQL = "SELECT productName, productPrice, productCount, totalPrice FROM DAILY_ORDER_RESULT WHERE reg like ?" ;

          pstmt = conn.prepareStatement(SQL);
          pstmt.setString(1, date);
          rs = pstmt.executeQuery();
          OrderDTO order;
          while(rs.next()){
              order = new OrderDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
              orderList.add(order);
          }               

      }catch(Exception e){
          e.printStackTrace();
      }finally{
          try{
              if(rs != null) rs.close();
              if(pstmt != null) pstmt.close();
          }catch(Exception e) {
              e.printStackTrace();
          }
      }
      return orderList;
  }
    
    //  날짜 Label을 클릭했을 때 일별로 매출을 보여주기 위한 ActionListener
    public class buttonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DailySalesForm ds = new DailySalesForm(); // 일별로 매출을 보여주는 Form 객체 생성
            if(e.getSource().equals(day1)){ // EX) 1월 1일 버튼을 클릭 했을 때
                
                ds.txtTitle.setText("2022년 1월 1일 판매 현황");

                if(getMonthlyCount("2022-01-01%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-01%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-01%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-01%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-01%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }

                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day2)){
                
                ds.txtTitle.setText("2022년 1월 2일 판매 현황");

                if(getMonthlyCount("2022-01-02%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-02%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-02%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-02%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-02%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }

                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day3)){
                
                ds.txtTitle.setText("2022년 1월 3일 판매 현황");

                if(getMonthlyCount("2022-01-03%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-03%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-03%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-03%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-03%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day4)){
                
                ds.txtTitle.setText("2022년 1월 4일 판매 현황");

                if(getMonthlyCount("2022-01-04%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-04%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-04%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-04%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-04%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day5)){
                
                ds.txtTitle.setText("2022년 1월 5일 판매 현황");

                if(getMonthlyCount("2022-01-05%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-05%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-05%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-05%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-05%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day6)){
                
                ds.txtTitle.setText("2022년 1월 6일 판매 현황");

                if(getMonthlyCount("2022-01-06%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-06%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-06%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-06%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-06%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day7)){
                
                ds.txtTitle.setText("2022년 1월 7일 판매 현황");

                if(getMonthlyCount("2022-01-07%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-07%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-07%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-07%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-07%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day8)){
                
                ds.txtTitle.setText("2022년 1월 8일 판매 현황");

                if(getMonthlyCount("2022-01-08%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-08%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-08%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-08%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-08%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day9)){
                
                ds.txtTitle.setText("2022년 1월 9일 판매 현황");

                if(getMonthlyCount("2022-01-09%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-09%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-09%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-09%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-09%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day10)){
                
                ds.txtTitle.setText("2022년 1월 10일 판매 현황");

                if(getMonthlyCount("2022-01-10%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-10%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-10%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-10%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-10%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day11)){
                
                ds.txtTitle.setText("2022년 1월 11일 판매 현황");

                if(getMonthlyCount("2022-01-11%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-11%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-11%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-11%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-11%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day12)){
                
                ds.txtTitle.setText("2022년 1월 12일 판매 현황");

                if(getMonthlyCount("2022-01-12%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-12%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-12%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-12%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-12%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day13)){
                
                ds.txtTitle.setText("2022년 1월 13일 판매 현황");

                if(getMonthlyCount("2022-01-13%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-13%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-13%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-13%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-13%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day14)){
                
                ds.txtTitle.setText("2022년 1월 14일 판매 현황");

                if(getMonthlyCount("2022-01-14%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-14%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-14%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-14%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-14%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day15)){
                
                ds.txtTitle.setText("2022년 1월 15일 판매 현황");

                if(getMonthlyCount("2022-01-15%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-15%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-15%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-15%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-15%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day16)){
                
                ds.txtTitle.setText("2022년 1월 16일 판매 현황");

                if(getMonthlyCount("2022-01-16%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-16%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-16%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-16%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-16%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day17)){
                
                ds.txtTitle.setText("2022년 1월 17일 판매 현황");

                if(getMonthlyCount("2022-01-17%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-17%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-17%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-17%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-17%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day18)){
                
                ds.txtTitle.setText("2022년 1월 18일 판매 현황");

                if(getMonthlyCount("2022-01-18%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-18%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-18%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-18%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-18%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day19)){
                
                ds.txtTitle.setText("2022년 1월 19일 판매 현황");

                if(getMonthlyCount("2022-01-19%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-19%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-19%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-19%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-19%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day20)){
                
                ds.txtTitle.setText("2022년 1월 720일 판매 현황");

                if(getMonthlyCount("2022-01-20%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-20%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-20%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-20%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-20%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day21)){
                
                ds.txtTitle.setText("2022년 1월 21일 판매 현황");

                if(getMonthlyCount("2022-01-21%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-21%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-21%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-21%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-21%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day22)){
                
                ds.txtTitle.setText("2022년 1월 22일 판매 현황");

                if(getMonthlyCount("2022-01-22%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-22%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-22%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-22%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-22%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day23)){
                
                ds.txtTitle.setText("2022년 1월 23일 판매 현황");

                if(getMonthlyCount("2022-01-23%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-23%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-23%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-23%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-23%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day24)){
                
                ds.txtTitle.setText("2022년 1월 24일 판매 현황");

                if(getMonthlyCount("2022-01-24%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-24%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-24%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-24%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-24%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day25)){
                
                ds.txtTitle.setText("2022년 1월 25일 판매 현황");

                if(getMonthlyCount("2022-01-25%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-25%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-25%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-25%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-25%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day26)){
                
                ds.txtTitle.setText("2022년 1월 26일 판매 현황");

                if(getMonthlyCount("2022-01-26%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-26%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-26%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-26%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-26%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day27)){
                
                ds.txtTitle.setText("2022년 1월 27일 판매 현황");

                if(getMonthlyCount("2022-01-27%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-27%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-27%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-27%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-27%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day28)){
                
                ds.txtTitle.setText("2022년 1월 28일 판매 현황");

                if(getMonthlyCount("2022-01-28%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-28%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-28%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-28%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-28%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day29)){
                
                ds.txtTitle.setText("2022년 1월 29일 판매 현황");

                if(getMonthlyCount("2022-01-29%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-29%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-29%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-29%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-29%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day30)){
                
                ds.txtTitle.setText("2022년 1월 30일 판매 현황");

                if(getMonthlyCount("2022-01-30%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-30%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-30%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-30%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-30%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }else if(e.getSource().equals(day31)){
                
                ds.txtTitle.setText("2022년 1월 31일 판매 현황");

                if(getMonthlyCount("2022-01-31%") != null){
                    ds.salesCnt.setText("  판매 건수 : " + getMonthlyCount("2022-01-31%") + "개");
                }else{
                    ds.salesCnt.setText(ds.salesCnt.getText() + " 0 개");
                }

                if(getMonthlySales("2022-01-31%") != null){
                    ds.totalSales.setText("  총 금액 : " + getMonthlySales("2022-01-31%") + "원");
                }else{
                    ds.totalSales.setText(ds.totalSales.getText() + " 0 원");
                }
                ArrayList<OrderDTO> list =  getOderList("2022-01-31%");
                DefaultTableModel model = (DefaultTableModel) ds.table.getModel();

                model.setNumRows(0);
                Object[] row = new Object[4];
                for(int i=0; i < list.size(); i++){
                    row[0] = list.get(i).getProductName();
                    row[1] = list.get(i).getProductPrice();
                    row[2] = list.get(i).getProductCount();
                    row[3] = list.get(i).getTotalPrice();

                    model.addRow(row);
                }
                ds.setVisible(true);
                dispose();
            }
        }// end actionPerformed
    }// end ActionListener
            
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton c;
    private javax.swing.JButton d10;
    private javax.swing.JButton d11;
    private javax.swing.JButton d12;
    private javax.swing.JButton d13;
    private javax.swing.JButton d14;
    private javax.swing.JButton d15;
    private javax.swing.JButton d16;
    private javax.swing.JButton d17;
    private javax.swing.JButton d18;
    private javax.swing.JButton d19;
    private javax.swing.JButton d20;
    private javax.swing.JButton d21;
    private javax.swing.JButton d22;
    private javax.swing.JButton d23;
    private javax.swing.JButton d24;
    private javax.swing.JButton d25;
    private javax.swing.JButton d26;
    private javax.swing.JButton d27;
    private javax.swing.JButton d28;
    private javax.swing.JButton d29;
    private javax.swing.JButton d30;
    private javax.swing.JButton d31;
    private javax.swing.JButton d32;
    private javax.swing.JButton d33;
    private javax.swing.JButton d35;
    private javax.swing.JButton d36;
    private javax.swing.JButton d7;
    private javax.swing.JButton d8;
    private javax.swing.JButton d9;
    private javax.swing.JButton day;
    private javax.swing.JButton day1;
    private javax.swing.JButton day10;
    private javax.swing.JButton day11;
    private javax.swing.JButton day12;
    private javax.swing.JButton day13;
    private javax.swing.JButton day14;
    private javax.swing.JButton day15;
    private javax.swing.JButton day16;
    private javax.swing.JButton day17;
    private javax.swing.JButton day18;
    private javax.swing.JButton day19;
    public javax.swing.JButton day2;
    private javax.swing.JButton day20;
    private javax.swing.JButton day21;
    private javax.swing.JButton day22;
    private javax.swing.JButton day23;
    private javax.swing.JButton day24;
    private javax.swing.JButton day25;
    private javax.swing.JButton day26;
    private javax.swing.JButton day27;
    private javax.swing.JButton day28;
    private javax.swing.JButton day29;
    private javax.swing.JButton day3;
    private javax.swing.JButton day30;
    private javax.swing.JButton day31;
    private javax.swing.JButton day4;
    private javax.swing.JButton day5;
    private javax.swing.JButton day6;
    private javax.swing.JButton day7;
    private javax.swing.JButton day8;
    private javax.swing.JButton day9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
