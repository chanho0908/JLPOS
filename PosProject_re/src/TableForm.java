
import DTO.BreadDTO;
import DTO.OrderDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class TableForm extends javax.swing.JFrame {
    public TableForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
        String time = format.format(date);

        dateLabel.setText(time);
        
        ArrayList<JButton> tables = new ArrayList<>();
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        tables.add(table4);
        tables.add(table5);
        tables.add(table6);
        tables.add(table7);
        tables.add(table8);
        tables.add(table9);
        tables.add(table10);
        tables.add(table11);
        tables.add(table12);
        tables.add(table13);
        
        for(JButton t : tables){
                // 버튼의 내부 테두리 제거
                t.setFocusPainted(false);
                
                // 13개의 테이블 버튼에 addActionListener 등록
                t.addActionListener(e ->{
                    
                    CustomerForm cf = new CustomerForm();
                    int sum = 0;
                    if(e.getSource().equals(table1)){
                        ArrayList<OrderDTO> list =  getOderList(1); //1번 테이블의 주문 목록
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        cf.tableNo.setText("1");
                        
                        model.setNumRows(0); // 주문 테이블 초기화
                        Object[] row = new Object[4]; // 테이블에 값을 넣기 위한 Object Type 배열 생성.
                        for(int i=0; i < list.size(); i++){
                            row[0] = list.get(i).getProductName(); // 상품 이름
                            row[1] = list.get(i).getProductPrice();  // 상품 가격
                            row[2] = list.get(i).getProductCount(); // 상품 수량
                            row[3] = list.get(i).getTotalPrice();      // 총 가격
                            
                            sum += list.get(i).getTotalPrice();      // 총 결재 금액을 출력하기 위해 sum에 저장

                            model.addRow(row); // 테이블에 추가
                        }
                        cf.payText.setText("결제 금액 : " + sum); 
                        
                    }else if(e.getSource().equals(table2)){
                        ArrayList<OrderDTO> list =  getOderList(2);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        cf.tableNo.setText("2");
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table3)){
                        cf.tableNo.setText("3");
                        ArrayList<OrderDTO> list =  getOderList(3);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table4)){
                        cf.tableNo.setText("4");
                        ArrayList<OrderDTO> list =  getOderList(4);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table5)){
                        cf.tableNo.setText("5");
                        ArrayList<OrderDTO> list =  getOderList(5);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table6)){
                        cf.tableNo.setText("6");
                        ArrayList<OrderDTO> list =  getOderList(6);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table7)){
                        cf.tableNo.setText("7");
                        ArrayList<OrderDTO> list =  getOderList(7);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table8)){
                        cf.tableNo.setText("8");
                        ArrayList<OrderDTO> list =  getOderList(8);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table9)){
                        cf.tableNo.setText("9");
                        ArrayList<OrderDTO> list =  getOderList(9);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table10)){
                        cf.tableNo.setText("10");
                        ArrayList<OrderDTO> list =  getOderList(10);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table11)){
                        cf.tableNo.setText("11");
                        ArrayList<OrderDTO> list =  getOderList(11);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table12)){
                        cf.tableNo.setText("12");
                        ArrayList<OrderDTO> list =  getOderList(12);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }else if(e.getSource().equals(table13)){
                        cf.tableNo.setText("13");
                        ArrayList<OrderDTO> list =  getOderList(13);
                        DefaultTableModel model = (DefaultTableModel) cf.table.getModel();
                        
                        model.setNumRows(0);
                        Object[] row = new Object[4];
                        for(int i=0; i < list.size(); i++){
                        row[0] = list.get(i).getProductName();
                        row[1] = list.get(i).getProductPrice();
                        row[2] = list.get(i).getProductCount();
                        row[3] = list.get(i).getTotalPrice();
                        
                        sum += list.get(i).getTotalPrice();
                        model.addRow(row);
                        }
                        cf.payText.setText("결제 금액 : " + sum);
                    }     
                    cf.setVisible(true);
                    cf.setLocationRelativeTo(null);
                });
        }
    }
    
    /**
     * 테이블을 클릭하고 상품을 주문한 다음 결제 버튼을 누르지 않고 뒤로 가기 버튼을 눌렀을 때
     * 저장되어 있던 주문 목록을 DB로 부터 가져오는 메소드.
     **/
    public ArrayList<OrderDTO> getOderList(int tableNo){
        ArrayList<OrderDTO> orderList = new ArrayList<>(); // 전체 주문 목록 저장 ArrayList
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DBconnection.getConnection();
            
            String SQL = "SELECT productName, productPrice, productCount, "
                    + "totalPrice FROM DAILY_ORDER WHERE TABLENO=?";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, tableNo);
            rs = pstmt.executeQuery();
            OrderDTO order; //  하나의 주문 (ex. 단팥빵, 3000, 3,  9000)을 담는 객체
            
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        table2 = new javax.swing.JButton();
        table4 = new javax.swing.JButton();
        table3 = new javax.swing.JButton();
        table1 = new javax.swing.JButton();
        table5 = new javax.swing.JButton();
        table6 = new javax.swing.JButton();
        table7 = new javax.swing.JButton();
        table8 = new javax.swing.JButton();
        table9 = new javax.swing.JButton();
        table12 = new javax.swing.JButton();
        table10 = new javax.swing.JButton();
        table11 = new javax.swing.JButton();
        table13 = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("x");
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JL POS");

        jPanel2.setBackground(new java.awt.Color(42, 62, 80));

        dateLabel.setFont(new java.awt.Font("맑은 고딕", 0, 16)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));

        table2.setBackground(new java.awt.Color(153, 204, 255));
        table2.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table2.setForeground(new java.awt.Color(255, 255, 255));
        table2.setText("2번 테이블");
        table2.setBorder(null);
        table2.setBorderPainted(false);
        table2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table2.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table4.setBackground(new java.awt.Color(153, 204, 255));
        table4.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table4.setForeground(new java.awt.Color(255, 255, 255));
        table4.setText("4번 테이블");
        table4.setBorder(null);
        table4.setBorderPainted(false);
        table4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table4.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table3.setBackground(new java.awt.Color(153, 204, 255));
        table3.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table3.setForeground(new java.awt.Color(255, 255, 255));
        table3.setText("3번 테이블");
        table3.setBorder(null);
        table3.setBorderPainted(false);
        table3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table3.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table1.setBackground(new java.awt.Color(153, 204, 255));
        table1.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table1.setForeground(new java.awt.Color(255, 255, 255));
        table1.setText("1번 테이블");
        table1.setBorder(null);
        table1.setBorderPainted(false);
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table1.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table5.setBackground(new java.awt.Color(153, 204, 255));
        table5.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table5.setForeground(new java.awt.Color(255, 255, 255));
        table5.setText("5번 테이블");
        table5.setBorder(null);
        table5.setBorderPainted(false);
        table5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table5.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table6.setBackground(new java.awt.Color(153, 204, 255));
        table6.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table6.setForeground(new java.awt.Color(255, 255, 255));
        table6.setText("6번 테이블");
        table6.setBorder(null);
        table6.setBorderPainted(false);
        table6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table6.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table7.setBackground(new java.awt.Color(153, 204, 255));
        table7.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table7.setForeground(new java.awt.Color(255, 255, 255));
        table7.setText("7번 테이블");
        table7.setBorder(null);
        table7.setBorderPainted(false);
        table7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table7.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table8.setBackground(new java.awt.Color(153, 204, 255));
        table8.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table8.setForeground(new java.awt.Color(255, 255, 255));
        table8.setText("8번 테이블");
        table8.setBorder(null);
        table8.setBorderPainted(false);
        table8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table8.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table9.setBackground(new java.awt.Color(153, 204, 255));
        table9.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table9.setForeground(new java.awt.Color(255, 255, 255));
        table9.setText("9번 테이블");
        table9.setBorder(null);
        table9.setBorderPainted(false);
        table9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table9.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table12.setBackground(new java.awt.Color(153, 204, 255));
        table12.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table12.setForeground(new java.awt.Color(255, 255, 255));
        table12.setText("12번 테이블");
        table12.setBorder(null);
        table12.setBorderPainted(false);
        table12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table12.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table12.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table10.setBackground(new java.awt.Color(153, 204, 255));
        table10.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table10.setForeground(new java.awt.Color(255, 255, 255));
        table10.setText("10번 테이블");
        table10.setBorder(null);
        table10.setBorderPainted(false);
        table10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table10.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table11.setBackground(new java.awt.Color(153, 204, 255));
        table11.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table11.setForeground(new java.awt.Color(255, 255, 255));
        table11.setText("11번 테이블");
        table11.setBorder(null);
        table11.setBorderPainted(false);
        table11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table11.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        table13.setBackground(new java.awt.Color(153, 204, 255));
        table13.setFont(new java.awt.Font("빙그레체", 1, 19)); // NOI18N
        table13.setForeground(new java.awt.Color(255, 255, 255));
        table13.setText("13번 테이블");
        table13.setBorder(null);
        table13.setBorderPainted(false);
        table13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table13.setMargin(new java.awt.Insets(20, 0, 0, 0));
        table13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(table9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(table6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(table7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(table8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(table5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(table2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(table6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(table10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnProduct.setBackground(new java.awt.Color(204, 204, 255));
        btnProduct.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btnProduct.setText("제품 관리");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnSales.setBackground(new java.awt.Color(204, 204, 255));
        btnSales.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btnSales.setText("일일 매출 현황");
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(btnSales, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelClose)
                            .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        ProductForm pf = new ProductForm();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        MonthlySalesForm ms = new MonthlySalesForm();
        ms.setVisible(true);
        ms.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnSalesActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnSales;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton table1;
    private javax.swing.JButton table10;
    private javax.swing.JButton table11;
    private javax.swing.JButton table12;
    private javax.swing.JButton table13;
    private javax.swing.JButton table2;
    private javax.swing.JButton table3;
    private javax.swing.JButton table4;
    private javax.swing.JButton table5;
    private javax.swing.JButton table6;
    private javax.swing.JButton table7;
    private javax.swing.JButton table8;
    private javax.swing.JButton table9;
    // End of variables declaration//GEN-END:variables
}
