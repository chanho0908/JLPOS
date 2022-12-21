import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JLabel;

//수정본
public class MonthlySalesForm extends javax.swing.JFrame {
    
    
    public MonthlySalesForm() {
        initComponents();
        btnExit.setFocusPainted(false);
        
        // getMonthlySales 메소드에서 각 월별로 총 매출량을 가져와 label에 SET 
        label1.setText(label1.getText() + getMonthlySales("2022-01%") + "원");
        label2.setText(label2.getText() + getMonthlySales("2022-02%") + "원");
        label3.setText(label3.getText() + getMonthlySales("2022-03%") + "원");
        label4.setText(label4.getText() + getMonthlySales("2022-04%") + "원");
        label5.setText(label5.getText() + getMonthlySales("2022-05%") + "원");
        label6.setText(label6.getText() + getMonthlySales("2022-06%") + "원");
        label7.setText(label7.getText() + getMonthlySales("2022-07%") + "원");
        label8.setText(label8.getText() + getMonthlySales("2022-08%") + "원");
        label9.setText(label9.getText() + getMonthlySales("2022-09%") + "원");
        label10.setText(label10.getText() + getMonthlySales("2022-10%") + "원");
        label11.setText(label11.getText() + getMonthlySales("2022-11%") + "원");
        label12.setText(label12.getText() + getMonthlySales("2022-12%") + "원");
    }
    
    /**
    *  DB의 총 매출을 저장하는 Table에서 
    *  where 절에서 각 월별로 Select 후 값을 가져와
    *  총 매출을 계산해 반환하는 메소드
    */
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
        monSales = new javax.swing.JPanel();
        JanBtn = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        FabBtn = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        marBtn = new javax.swing.JButton();
        aprBtn = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        MayBtn = new javax.swing.JButton();
        label5 = new javax.swing.JLabel();
        JuneBtn = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        AugBtn = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        SepBtn = new javax.swing.JButton();
        label9 = new javax.swing.JLabel();
        OctBtn = new javax.swing.JButton();
        label10 = new javax.swing.JLabel();
        NovBtn = new javax.swing.JButton();
        label11 = new javax.swing.JLabel();
        DecBtn = new javax.swing.JButton();
        label12 = new javax.swing.JLabel();
        JulyBtn = new javax.swing.JButton();
        label7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JanBtn.setBackground(new java.awt.Color(102, 102, 102));
        JanBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        JanBtn.setForeground(new java.awt.Color(255, 255, 255));
        JanBtn.setText("1월");
        JanBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        JanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JanBtnActionPerformed(evt);
            }
        });

        label1.setBackground(new java.awt.Color(102, 102, 102));
        label1.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("  매출 : ");
        label1.setOpaque(true);

        FabBtn.setBackground(new java.awt.Color(102, 102, 102));
        FabBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        FabBtn.setForeground(new java.awt.Color(255, 255, 255));
        FabBtn.setText("2월");
        FabBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label2.setBackground(new java.awt.Color(102, 102, 102));
        label2.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("  매출 : ");
        label2.setOpaque(true);

        label3.setBackground(new java.awt.Color(102, 102, 102));
        label3.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("  매출 : ");
        label3.setOpaque(true);

        marBtn.setBackground(new java.awt.Color(102, 102, 102));
        marBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        marBtn.setForeground(new java.awt.Color(255, 255, 255));
        marBtn.setText("3월");
        marBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        aprBtn.setBackground(new java.awt.Color(102, 102, 102));
        aprBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        aprBtn.setForeground(new java.awt.Color(255, 255, 255));
        aprBtn.setText("4월");
        aprBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label4.setBackground(new java.awt.Color(102, 102, 102));
        label4.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("  매출 : ");
        label4.setOpaque(true);

        MayBtn.setBackground(new java.awt.Color(102, 102, 102));
        MayBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        MayBtn.setForeground(new java.awt.Color(255, 255, 255));
        MayBtn.setText("5월");
        MayBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label5.setBackground(new java.awt.Color(102, 102, 102));
        label5.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("  매출 : ");
        label5.setOpaque(true);

        JuneBtn.setBackground(new java.awt.Color(102, 102, 102));
        JuneBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        JuneBtn.setForeground(new java.awt.Color(255, 255, 255));
        JuneBtn.setText("6월");
        JuneBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label6.setBackground(new java.awt.Color(102, 102, 102));
        label6.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("  매출 : ");
        label6.setOpaque(true);

        AugBtn.setBackground(new java.awt.Color(102, 102, 102));
        AugBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        AugBtn.setForeground(new java.awt.Color(255, 255, 255));
        AugBtn.setText("8월");
        AugBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label8.setBackground(new java.awt.Color(102, 102, 102));
        label8.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 255, 255));
        label8.setText("  매출 : ");
        label8.setOpaque(true);

        SepBtn.setBackground(new java.awt.Color(102, 102, 102));
        SepBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        SepBtn.setForeground(new java.awt.Color(255, 255, 255));
        SepBtn.setText("9월");
        SepBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label9.setBackground(new java.awt.Color(102, 102, 102));
        label9.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 255, 255));
        label9.setText("  매출 : ");
        label9.setOpaque(true);

        OctBtn.setBackground(new java.awt.Color(102, 102, 102));
        OctBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        OctBtn.setForeground(new java.awt.Color(255, 255, 255));
        OctBtn.setText("10월");
        OctBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label10.setBackground(new java.awt.Color(102, 102, 102));
        label10.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label10.setForeground(new java.awt.Color(255, 255, 255));
        label10.setText("  매출 : ");
        label10.setOpaque(true);

        NovBtn.setBackground(new java.awt.Color(102, 102, 102));
        NovBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        NovBtn.setForeground(new java.awt.Color(255, 255, 255));
        NovBtn.setText("11월");
        NovBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label11.setBackground(new java.awt.Color(102, 102, 102));
        label11.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));
        label11.setText("  매출 : ");
        label11.setOpaque(true);

        DecBtn.setBackground(new java.awt.Color(102, 102, 102));
        DecBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        DecBtn.setForeground(new java.awt.Color(255, 255, 255));
        DecBtn.setText("12월");
        DecBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label12.setBackground(new java.awt.Color(102, 102, 102));
        label12.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        label12.setForeground(new java.awt.Color(255, 255, 255));
        label12.setText("  매출 : ");
        label12.setOpaque(true);

        JulyBtn.setBackground(new java.awt.Color(102, 102, 102));
        JulyBtn.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        JulyBtn.setForeground(new java.awt.Color(255, 255, 255));
        JulyBtn.setText("7월");
        JulyBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label7.setBackground(new java.awt.Color(102, 102, 102));
        label7.setFont(new java.awt.Font("맑은 고딕", 1, 17)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("  매출 : ");
        label7.setOpaque(true);

        javax.swing.GroupLayout monSalesLayout = new javax.swing.GroupLayout(monSales);
        monSales.setLayout(monSalesLayout);
        monSalesLayout.setHorizontalGroup(
            monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monSalesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(JulyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FabBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(marBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AugBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SepBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OctBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NovBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DecBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aprBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JuneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        monSalesLayout.setVerticalGroup(
            monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monSalesLayout.createSequentialGroup()
                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(JuneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(MayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(aprBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(marBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(FabBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addComponent(JanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, monSalesLayout.createSequentialGroup()
                                        .addComponent(SepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(monSalesLayout.createSequentialGroup()
                                            .addComponent(NovBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(monSalesLayout.createSequentialGroup()
                                            .addComponent(OctBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(monSalesLayout.createSequentialGroup()
                                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(monSalesLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(AugBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monSalesLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(JulyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(monSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(monSalesLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(DecBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("2022년 월별 매출 현황");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        TableForm tf = new TableForm();
        tf.setVisible(true);
        tf.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void JanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JanBtnActionPerformed
        DailyForm df = new DailyForm();
        df.setVisible(true);
        df.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_JanBtnActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlySalesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AugBtn;
    private javax.swing.JButton DecBtn;
    private javax.swing.JButton FabBtn;
    private javax.swing.JButton JanBtn;
    private javax.swing.JButton JulyBtn;
    private javax.swing.JButton JuneBtn;
    private javax.swing.JButton MayBtn;
    private javax.swing.JButton NovBtn;
    private javax.swing.JButton OctBtn;
    private javax.swing.JButton SepBtn;
    private javax.swing.JButton aprBtn;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JButton marBtn;
    private javax.swing.JPanel monSales;
    // End of variables declaration//GEN-END:variables
}
