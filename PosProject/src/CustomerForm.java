import DTO.OrderDTO;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;


public class CustomerForm extends javax.swing.JFrame {
    ArrayList<OrderDTO> orderList = new ArrayList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<JLabel> cakeLabels = new ArrayList<>();
    ArrayList<JLabel> breadLabels = new ArrayList<>();
    ArrayList<JLabel> drinkLabels = new ArrayList<>();
    ArrayList<JLabel> breadPrices = new ArrayList<>();
    ArrayList<JLabel> cakePrices = new ArrayList<>();
    ArrayList<JLabel> drinkPrices = new ArrayList<>();
    
    public CustomerForm() {
        initComponents();
        setLocationRelativeTo(null);
        
        // 스크롤바 속도 조정
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        // Label Text 가운데 정렬
        payText.setHorizontalAlignment(JLabel.CENTER);
        
        table.getColumnModel().getColumn(0).setMaxWidth(160);
        table.getColumnModel().getColumn(0).setMinWidth(160);
        table.getColumnModel().getColumn(0).setWidth(160);
        
        //테이블 셀 높이 조절
        table.setRowHeight(30);
        
        addLabel();
        
        setLabel("bread");
        setLabel("cake");
        setLabel("drink");
               
        // 버튼의 내부 테두리 제거
        btnExit.setFocusPainted(false);
        
        q1.setVisible(false);
       
    }
    
    // 테이블에 데이터를 추가하는 메소드
    public void addTable(String name, int price, int cnt, int total){
        //DefaultTableModel를 이용해 직접적인 Model 객체를 생성
        // 이를 가지고 데이터를 삽입,수정,삭제가 가능
        DefaultTableModel dt = (DefaultTableModel) table.getModel();
        
        //테이블 행의 수 만큼 반복
        for(int row=0;  row < table.getRowCount(); row++){
                
                // (row, 0) 즉, 추가하려는 상품명과 동일한 상품이 존재한다면 
                if(name.equals(table.getValueAt(row, 0))){
                    
                     // 사람의 관점에서 보는 행의 index 반환
                    // index값이 0이 아닌 1부터 시작!
                    int r = table.convertRowIndexToModel(row);
                    
                    // 해당 열을 제거
                    dt.removeRow(r);                      
                }
        }
        // Table에 넣을 수 있는 자료 형 : Object / Vector / TableModel
        Vector v = new Vector();
        v.add(name);
        v.add(price);
        v.add(cnt);
        v.add(total);
        
        //테이블에 새로운 열 추가
        dt.addRow(v);      
    }
    
    // 전체 금액 계산 메소드
    public int totalPayment(){
        int sum = 0;
        int rowCnt = table.getRowCount();
        
        for(int row = 0; row < rowCnt; row++){
            int op = Integer.parseInt(table.getValueAt(row, 3).toString()) ;
            sum += op;
        }
        return sum;
    }
    
    
    public void addLabel(){
        cakeLabels.add(cName1);
        cakeLabels.add(cName2);
        cakeLabels.add(cName3);
        cakeLabels.add(cName4);
        cakeLabels.add(cName5);
        
        breadLabels.add(bName1);
        breadLabels.add(bName2);
        breadLabels.add(bName3);
        breadLabels.add(bName4);
        breadLabels.add(bName5);
        
        drinkLabels.add(dName1);
        drinkLabels.add(dName2);
        drinkLabels.add(dName3);
        drinkLabels.add(dName4);
        drinkLabels.add(dName5);
        
        buttons.add(cButton1);
        buttons.add(cButton2);
        buttons.add(cButton3);
        buttons.add(cButton4);
        buttons.add(cButton5);
        
        buttons.add(bButton1);
        buttons.add(bButton2);
        buttons.add(bButton3);
        buttons.add(bButton4);
        buttons.add(bButton5);
        
        buttons.add(dButton1);
        buttons.add(dButton2);
        buttons.add(dButton3);
        buttons.add(dButton4);
        buttons.add(dButton5);
        
        breadPrices.add(bPrice1);
        breadPrices.add(bPrice2);
        breadPrices.add(bPrice3);
        breadPrices.add(bPrice4);
        breadPrices.add(bPrice5);
        
        cakePrices.add(cPrice1);
        cakePrices.add(cPrice2);
        cakePrices.add(cPrice3);
        cakePrices.add(cPrice4);
        cakePrices.add(cPrice5);
        
        drinkPrices.add(dPrice1);
        drinkPrices.add(dPrice2);
        drinkPrices.add(dPrice3);
        drinkPrices.add(dPrice4);
        drinkPrices.add(dPrice5);
        
        for(JButton b : buttons){
            b.addActionListener(new buttonActionListener());
        }
    }
    
    
    /**
    * 
    * DB에 저장된 상품의 이름, 가격을 상품 카테고리 별로 가져와 
    * ArrayList에 저장 후 JLabel에 setText().
    *
    */
    public void setLabel(String kind){
        try{
            Connection conn = DBconnection.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String SQL = "select name, price from " + kind + " order by price";
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> prices = new ArrayList<>();
            
            while(rs.next()){
                names.add(rs.getString(1));
                prices.add(rs.getString(2));
            }
            
            switch (kind) {
                case "bread":
                    for(int i =0; i < names.size(); i++){
                        breadLabels.get(i).setText(names.get(i)); // 빵 이름
                        breadPrices.get(i).setText(prices.get(i));  // 빵 가격
                    }
                    break;
                case "cake":
                    for(int i =0; i < names.size(); i++){
                        cakeLabels.get(i).setText(names.get(i));
                        cakePrices.get(i).setText(prices.get(i));
                    }
                    break;    
                case "drink":
                    for(int i =0; i < names.size(); i++){
                        drinkLabels.get(i).setText(names.get(i));
                        drinkPrices.get(i).setText(prices.get(i));
                    }
                    break;    
            }
            
        }catch(Exception e){System.out.println(e.getMessage());}
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        cakePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCalc = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTable1 = new javax.swing.JTable();
        payText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        tableNo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        drinkBtn = new javax.swing.JButton();
        cakeBtn = new javax.swing.JButton();
        breadBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        bName1 = new javax.swing.JLabel();
        bPrice2 = new javax.swing.JLabel();
        bName2 = new javax.swing.JLabel();
        bPrice1 = new javax.swing.JLabel();
        bButton2 = new javax.swing.JButton();
        bName3 = new javax.swing.JLabel();
        bPrice3 = new javax.swing.JLabel();
        cButton2 = new javax.swing.JButton();
        bButton4 = new javax.swing.JButton();
        cButton4 = new javax.swing.JButton();
        cButton1 = new javax.swing.JButton();
        cButton5 = new javax.swing.JButton();
        cButton3 = new javax.swing.JButton();
        dButton2 = new javax.swing.JButton();
        bButton5 = new javax.swing.JButton();
        dButton1 = new javax.swing.JButton();
        dButton3 = new javax.swing.JButton();
        dButton5 = new javax.swing.JButton();
        cName1 = new javax.swing.JLabel();
        cPrice1 = new javax.swing.JLabel();
        cName4 = new javax.swing.JLabel();
        bPrice4 = new javax.swing.JLabel();
        bName5 = new javax.swing.JLabel();
        bPrice5 = new javax.swing.JLabel();
        bName4 = new javax.swing.JLabel();
        cPrice3 = new javax.swing.JLabel();
        cName2 = new javax.swing.JLabel();
        cPrice4 = new javax.swing.JLabel();
        cPrice2 = new javax.swing.JLabel();
        cName3 = new javax.swing.JLabel();
        dName2 = new javax.swing.JLabel();
        dPrice2 = new javax.swing.JLabel();
        dButton4 = new javax.swing.JButton();
        cName5 = new javax.swing.JLabel();
        cPrice5 = new javax.swing.JLabel();
        dName1 = new javax.swing.JLabel();
        dPrice1 = new javax.swing.JLabel();
        dName3 = new javax.swing.JLabel();
        dPrice5 = new javax.swing.JLabel();
        dName5 = new javax.swing.JLabel();
        dPrice3 = new javax.swing.JLabel();
        dName4 = new javax.swing.JLabel();
        dPrice4 = new javax.swing.JLabel();
        bButton1 = new javax.swing.JButton();
        bButton3 = new javax.swing.JButton();
        q1 = new javax.swing.JLabel();
        q3 = new javax.swing.JLabel();
        q4 = new javax.swing.JLabel();
        q5 = new javax.swing.JLabel();
        q6 = new javax.swing.JLabel();
        q7 = new javax.swing.JLabel();
        q8 = new javax.swing.JLabel();
        q9 = new javax.swing.JLabel();
        q10 = new javax.swing.JLabel();
        q11 = new javax.swing.JLabel();
        q12 = new javax.swing.JLabel();
        q13 = new javax.swing.JLabel();
        q14 = new javax.swing.JLabel();
        q15 = new javax.swing.JLabel();
        q2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        cakePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        btnCalc.setBackground(new java.awt.Color(0, 0, 0));
        btnCalc.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        btnCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCalc.setText("결제하기");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(250, 250, 250));
        btnDel.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        btnDel.setText("삭제");
        btnDel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "제품명", "가격", "수량", "총금액"
            }
        ));
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(table);

        jTable1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "상품", "가격", "개수", "금액"
            }
        ));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        payText.setFont(new java.awt.Font("맑은 고딕", 1, 30)); // NOI18N
        payText.setText("결제 금액 : 0");
        payText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCalc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(payText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setBackground(new java.awt.Color(44, 62, 80));
        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("상품");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(44, 62, 80));
        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("주문 내역");
        jLabel4.setOpaque(true);

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

        tableNo.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        tableNo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableNo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1123, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        drinkBtn.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        drinkBtn.setText("Drink");
        drinkBtn.setBorder(null);
        drinkBtn.setContentAreaFilled(false);
        drinkBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drinkBtn.setFocusPainted(false);

        cakeBtn.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cakeBtn.setText("Cake");
        cakeBtn.setBorder(null);
        cakeBtn.setContentAreaFilled(false);
        cakeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cakeBtn.setFocusPainted(false);

        breadBtn.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        breadBtn.setText("Bread");
        breadBtn.setBorder(null);
        breadBtn.setContentAreaFilled(false);
        breadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        breadBtn.setFocusPainted(false);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bName1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bName1.setText("트리맨의 초대");

        bPrice2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice2.setText("36200");

        bName2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bName2.setText("트리맨의 초대");

        bPrice1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice1.setText("36000");

        bButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/블루베리도넛.png"))); // NOI18N

        bName3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bName3.setText("트리맨의 초대");

        bPrice3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice3.setText("36200");

        cButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/우유바닐라케이크.png"))); // NOI18N

        bButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/피자토스트.png"))); // NOI18N
        bButton4.setToolTipText("");

        cButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/초코생크림케이크.png"))); // NOI18N

        cButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/티라미수케이크.png"))); // NOI18N

        cButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/호랑이케이크.png"))); // NOI18N

        cButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/생크림케이크.png"))); // NOI18N

        dButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/카페라떼.png"))); // NOI18N

        bButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/밤식빵.png"))); // NOI18N

        dButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/아메리카노.png"))); // NOI18N

        dButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/바닐라라떼.png"))); // NOI18N

        dButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/딸기파인스무디.png"))); // NOI18N

        cName1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cPrice1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPrice1.setText("36000");

        cName4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName4.setText("트리맨의 초대");

        bPrice4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice4.setText("36000");

        bName5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bPrice5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bPrice5.setText("36000");

        bName4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        bName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cPrice3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPrice3.setText("36000");

        cName2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName2.setText("트리맨의 초대");

        cPrice4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPrice4.setText("36000");

        cPrice2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPrice2.setText("36000");

        cName3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName3.setText("트리맨의 초대");

        dName2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dName2.setText("트리맨의 초대");

        dPrice2.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dPrice2.setText("36000");

        dButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/수박스무디.png"))); // NOI18N

        cName5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName5.setText("트리맨의 초대");

        cPrice5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        cPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPrice5.setText("36000");

        dName1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dName1.setText("트리맨의 초대");

        dPrice1.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dPrice1.setText("36000");

        dName3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dName3.setText("트리맨의 초대");

        dPrice5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dPrice5.setText("36000");

        dName5.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dName5.setText("트리맨의 초대");

        dPrice3.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dPrice3.setText("36000");

        dName4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dName4.setText("트리맨의 초대");

        dPrice4.setFont(new java.awt.Font("빙그레체", 0, 16)); // NOI18N
        dPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dPrice4.setText("36000");

        bButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/단팥빵.png"))); // NOI18N

        bButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/크림코르네.png"))); // NOI18N

        q1.setText("0");

        q3.setText("0");

        q4.setText("0");

        q5.setText("0");

        q6.setText("0");

        q7.setText("0");

        q8.setText("0");

        q9.setText("0");

        q10.setText("0");

        q11.setText("0");

        q12.setText("0");

        q13.setText("0");

        q14.setText("0");

        q15.setText("0");

        q2.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dName4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cName2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(bPrice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bName4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(bName1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(q1))
                                .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dName3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cName5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bName5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cName1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(221, 221, 221)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bName2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bName3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(bButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cName3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(dButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cName4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dName2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dName5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(dPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(dName1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(721, Short.MAX_VALUE)
                    .addComponent(q3)
                    .addGap(247, 247, 247)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(731, Short.MAX_VALUE)
                    .addComponent(q4)
                    .addGap(237, 237, 237)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(741, Short.MAX_VALUE)
                    .addComponent(q5)
                    .addGap(227, 227, 227)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(751, Short.MAX_VALUE)
                    .addComponent(q6)
                    .addGap(217, 217, 217)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(761, Short.MAX_VALUE)
                    .addComponent(q7)
                    .addGap(207, 207, 207)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(771, Short.MAX_VALUE)
                    .addComponent(q8)
                    .addGap(197, 197, 197)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(781, Short.MAX_VALUE)
                    .addComponent(q9)
                    .addGap(187, 187, 187)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(791, Short.MAX_VALUE)
                    .addComponent(q10)
                    .addGap(177, 177, 177)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(801, Short.MAX_VALUE)
                    .addComponent(q11)
                    .addGap(167, 167, 167)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(811, Short.MAX_VALUE)
                    .addComponent(q12)
                    .addGap(157, 157, 157)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(821, Short.MAX_VALUE)
                    .addComponent(q13)
                    .addGap(147, 147, 147)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(831, Short.MAX_VALUE)
                    .addComponent(q14)
                    .addGap(137, 137, 137)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(841, Short.MAX_VALUE)
                    .addComponent(q15)
                    .addGap(127, 127, 127)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(731, Short.MAX_VALUE)
                    .addComponent(q2)
                    .addGap(237, 237, 237)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bName3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bName1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bName2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(q1)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cName1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bName4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bName5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cName4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cName3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cName5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dName1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dName2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dName3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dName4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dName5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1364, Short.MAX_VALUE)
                    .addComponent(q3)
                    .addGap(279, 279, 279)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1374, Short.MAX_VALUE)
                    .addComponent(q4)
                    .addGap(269, 269, 269)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1384, Short.MAX_VALUE)
                    .addComponent(q5)
                    .addGap(259, 259, 259)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1394, Short.MAX_VALUE)
                    .addComponent(q6)
                    .addGap(249, 249, 249)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1404, Short.MAX_VALUE)
                    .addComponent(q7)
                    .addGap(239, 239, 239)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1414, Short.MAX_VALUE)
                    .addComponent(q8)
                    .addGap(229, 229, 229)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1424, Short.MAX_VALUE)
                    .addComponent(q9)
                    .addGap(219, 219, 219)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1434, Short.MAX_VALUE)
                    .addComponent(q10)
                    .addGap(209, 209, 209)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1444, Short.MAX_VALUE)
                    .addComponent(q11)
                    .addGap(199, 199, 199)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1454, Short.MAX_VALUE)
                    .addComponent(q12)
                    .addGap(189, 189, 189)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1464, Short.MAX_VALUE)
                    .addComponent(q13)
                    .addGap(179, 179, 179)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1474, Short.MAX_VALUE)
                    .addComponent(q14)
                    .addGap(169, 169, 169)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1484, Short.MAX_VALUE)
                    .addComponent(q15)
                    .addGap(159, 159, 159)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1374, Short.MAX_VALUE)
                    .addComponent(q2)
                    .addGap(269, 269, 269)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(breadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(cakeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(drinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(cakeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cakePanelLayout = new javax.swing.GroupLayout(cakePanel);
        cakePanel.setLayout(cakePanelLayout);
        cakePanelLayout.setHorizontalGroup(
            cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cakePanelLayout.createSequentialGroup()
                .addGroup(cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(cakePanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cakePanelLayout.setVerticalGroup(
            cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cakePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(cakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cakePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cakePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    //  제품 삭제 메소드  
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // 테이블 모델
        
        try{
            int selRow = table.getSelectedRow(); // 선택된 행
            String r = model.getValueAt(selRow, 0).toString(); // 선택된 행의 0번 째 값 (제품 이름)

            model.removeRow(selRow); // 선택된 행을 삭제

            if(r.equals(bName1.getText())){ // 수량을 0으로 초기화
                q1.setText("0");            
            }else if(r.equals(bName2.getText())){
                q2.setText("0");            
            }else if(r.equals(bName3.getText())){
                q3.setText("0");            
            }else if(r.equals(bName4.getText())){
                q4.setText("0");            
            }else if(r.equals(bName5.getText())){
                q5.setText("0");            
            }else if(r.equals(cName1.getText())){
                q6.setText("0");            
            }else if(r.equals(cName2.getText())){
                q7.setText("0");            
            }else if(r.equals(cName3.getText())){
                q8.setText("0");            
            }else if(r.equals(cName4.getText())){
                q9.setText("0");            
            }else if(r.equals(cName5.getText())){
                q10.setText("0");            
            }else if(r.equals(dName1.getText())){
                q11.setText("0");            
            }else if(r.equals(dName2.getText())){
                q12.setText("0");            
            }else if(r.equals(dName3.getText())){
                q13.setText("0");            
            }else if(r.equals(dName4.getText())){
                q14.setText("0");            
            }else if(r.equals(dName5.getText())){
                q15.setText("0");            
            }

            payText.setText("결제 금액 : " + String.valueOf(totalPayment()));
        }catch(ArrayIndexOutOfBoundsException E){
            showMessageDialog(null, "삭제할 상품을 선택해 주세요!");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    /**
     * 상품을 주문하고 테이블에 상품이 set된 상태에서
     * 결제하기 버튼을 클릭하지 않고 이전 화면으로 이동했을 때, 주문 목록을 
     * DB에 저장하기 위한 메소드
     **/
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int no = Integer.parseInt(tableNo.getText()); // 테이블 번호
        DefaultTableModel model = (DefaultTableModel) table.getModel(); //테이블 모델
        OrderDTO dto; // 하나의 주문 저장 객체 (ex. 단팥빵, 3000, 3, 9000)
        String name; // 이름
        int price, cnt, sum; //가격 , 수량 , 전체 가격
        int row = model.getRowCount(); // 테이블 행의 수
        
        Connection conn = null;
        PreparedStatement pstmt = null;      
        String SQL = "Delete from Daily_Order where tableNo=?" ; 
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, no);
            pstmt.executeUpdate();  // 이전에 있던 주문 목록 삭제
            
            for(int i =0; i <  row; i++){ // 테이블 행의 수 만큼 반복하면서
                name = table.getValueAt(i, 0).toString(); // 이름
                price = Integer.parseInt(table.getValueAt(i, 1).toString()); //가격
                cnt = Integer.parseInt(table.getValueAt(i, 2).toString()); //수량
                sum = Integer.parseInt(table.getValueAt(i, 3).toString()); // 총 가격
                dto = new OrderDTO(name, price, cnt, sum); //하나의 객체에 담고
                
                insertToDB(dto);    // DB에 저장.
            }
        }catch(Exception e){
            e.printStackTrace();
        }try{
            if(pstmt != null){pstmt.close();}
        }catch(Exception e){e.printStackTrace();}
        
        
        TableForm tf = new TableForm();
        tf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    
    // 결제 기능 메소드
    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        
        OrderDTO dto;
        String name;
        int price=0;
        int cnt = 0;
        int sum =0;
        String n = tableNo.getText().toString();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getRowCount();
        System.out.println("ROW:" + row);
        int result = JOptionPane.showConfirmDialog(null, "결제 하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
        
        // 결제하겠습니까 ? 선택창을 출력
        // >> 예, 아니오 선택 없이 닫은 경우
        if(result == JOptionPane.CLOSED_OPTION){ //아니오 버튼 클릭 >> 결제 취소
            return;
        }else if(result == JOptionPane.YES_OPTION){ // 네 버튼 클릭 >> 결제
                if(row > 0){
                    /**
                    * 전체 테이블의 행 개수 만큼 반복하여
                    *  총 매출을 저장하는 insertToResultDB() 메소드 실행
                     */

                    for(int r =0; r < table.getRowCount(); r++){
                        
                        name = table.getValueAt(r, 0).toString();
                        
                        price = Integer.parseInt(table.getValueAt(r, 1).toString()); 
                        cnt = Integer.parseInt(table.getValueAt(r, 2).toString());
                        sum = Integer.parseInt(table.getValueAt(r, 3).toString());
                        dto = new OrderDTO(name, price, cnt, sum);
                        insertToResultDB(dto); 
                     
                    }
                    showMessageDialog(null, "결제가 완료 되었습니다.");
                    model.setRowCount(0);
                    deleteFromDB(n);
                   new TableForm().setVisible(true);
                   this.dispose();
                }else{
                    showMessageDialog(null, "결제할 상품을 선택해 주세요");
                    return;
                }
        }else{
            return;
        }
    }//GEN-LAST:event_btnCalcActionPerformed
    
     //daily_order Table : 테이블 별 주문 목록 저장 테이블
    // daily_order에 Data 저장 메소드
     public void insertToDB(OrderDTO dto){
        int no = Integer.parseInt(tableNo.getText());
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String SQL = "INSERT INTO daily_order VALUES(?, ?, ?, ?, ?)";
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, no);
            pstmt.setString(2, dto.getProductName());
            pstmt.setInt(3, dto.getProductPrice());
            pstmt.setInt(4, dto.getProductCount());
            pstmt.setInt(5, dto.getTotalPrice());
        
            pstmt.executeUpdate();
        
        }catch(Exception e){e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
            }catch(Exception e){e.printStackTrace();}
        }
    }
    
     //daily_order_result : 총 매출 저장 테이블
     // daily_order_result에 Data 저장 메소드
    public void insertToResultDB(OrderDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        String SQL = "INSERT INTO daily_order_result VALUES(?, ?, ?, ?, now())";
        try{
        conn = DBconnection.getConnection();
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, dto.getProductName());
        pstmt.setInt(2, dto.getProductPrice());
        pstmt.setInt(3, dto.getProductCount());
        pstmt.setInt(4, dto.getTotalPrice());
        
        pstmt.executeUpdate();
        
        }catch(Exception e){e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
            }catch(Exception e){e.printStackTrace();}
        }
    }
    
    // 결제 버튼을 눌렀을 때, 테이블 별로 DB에 저장된 주문 목록을 삭제
    public void deleteFromDB(String tableNo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String SQL = "Delete from daily_order where tableNo=?";
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, tableNo);
            
            pstmt.executeUpdate();
        
        }catch(Exception e){e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
            }catch(Exception e){e.printStackTrace();}
        }
        
    }
    
    // 주문 목록에 있는 전체 주문 정보를 반환하는 메소드
    public ArrayList<OrderDTO> getTableData(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCnt = model.getRowCount();
        String name = "";
        int price = 0;
        int cnt = 0;
        int total;
        OrderDTO order;
                        
        for(int i = 0; i < rowCnt; i++){
            name = model.getValueAt(i, 0).toString();
            price = Integer.parseInt(table.getValueAt(i, 1).toString()); 
            cnt = Integer.parseInt(table.getValueAt(i, 2).toString());
            total = Integer.parseInt(table.getValueAt(i, 3).toString());

            order = new OrderDTO(name, price, cnt, total);
            orderList.add(order);
        }   
        
        return orderList;
    }
    
    /**
     * 상품을 클릭했을 때 클릭한 상품의 정보를 테이블에 추가하기 위한 ActionListener
     * q* : 상품을 클릭했을 때 수량을 계속 증가 시키기 위해 사용
     * ex) 상품 1을 클릭하고 상품 2를 클릭했을 때 상품 1의 수량이 초기화 되는 현상 발생
     *      이를 해결하기 위해 단순히 수량만 상품의 수량만을 위한 Label을 생성한다
     *      상품의 값을 증가시키면 label의 값 또한 증가 시키게 되면 상품의 수량이 저장되는
     *      효과가 나타난다 이를 통해 계속해서 q* 의 값을 가져와 상품의 수량을 update 하면 
     *      여러가지 상품을 클릭해도 수량이 정상적으로 늘어나게 된다.
     */
    public class buttonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(bButton1)){ 
                //  : 빵 상품 1을 클릭했을 때,
                int i = Integer.valueOf(q1.getText()); 
                ++i;
                q1.setText(String.valueOf(i));

                String name = bName1.getText();
                int price = Integer.parseInt(bPrice1.getText());

                addTable(name, price, i, price*i);
                
            }else if(e.getSource().equals(bButton2)){
                int i = Integer.valueOf(q2.getText());
                ++i;
                q2.setText(String.valueOf(i));

                String name = bName2.getText();
                int price = Integer.parseInt(bPrice2.getText());

                addTable(name, price, i, price*i);
                
            }else if(e.getSource().equals(bButton3)){
                int i = Integer.valueOf(q3.getText());
                ++i;
                q3.setText(String.valueOf(i));

                String name = bName3.getText();
                int price = Integer.parseInt(bPrice3.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(bButton4)){
                int i = Integer.valueOf(q4.getText());
                ++i;
                q4.setText(String.valueOf(i));

                String name = bName4.getText();
                int price = Integer.parseInt(bPrice4.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(bButton5)){
                int i = Integer.valueOf(q5.getText());
                ++i;
                q5.setText(String.valueOf(i));

                String name = bName5.getText();
                int price = Integer.parseInt(bPrice5.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(cButton1)){
                int i = Integer.valueOf(q6.getText());
                ++i;
                q6.setText(String.valueOf(i));

                String name = cName1.getText();
                int price = Integer.parseInt(cPrice1.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(cButton2)){
                int i = Integer.valueOf(q7.getText());
                ++i;
                q7.setText(String.valueOf(i));

                String name = cName2.getText();
                int price = Integer.parseInt(cPrice2.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(cButton3)){
                int i = Integer.valueOf(q8.getText());
                ++i;
                q8.setText(String.valueOf(i));

                String name = cName3.getText();
                int price = Integer.parseInt(cPrice3.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(cButton4)){
                int i = Integer.valueOf(q8.getText());
                ++i;
                q9.setText(String.valueOf(i));

                String name = cName4.getText();
                int price = Integer.parseInt(cPrice4.getText());

                addTable(name, price, i, price*i);
            }
            else if(e.getSource().equals(cButton5)){
                int i = Integer.valueOf(q10.getText());
                ++i;
                q10.setText(String.valueOf(i));

                String name = cName5.getText();
                int price = Integer.parseInt(cPrice5.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(dButton1)){
                int i = Integer.valueOf(q11.getText());
                ++i;
                q11.setText(String.valueOf(i));

                String name = dName1.getText();
                int price = Integer.parseInt(dPrice1.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(dButton2)){
                int i = Integer.valueOf(q12.getText());
                ++i;
                q12.setText(String.valueOf(i));

                String name = dName2.getText();
                int price = Integer.parseInt(dPrice2.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(dButton3)){
                int i = Integer.valueOf(q13.getText());
                ++i;
                q13.setText(String.valueOf(i));

                String name = dName3.getText();
                int price = Integer.parseInt(dPrice3.getText());

                addTable(name, price, i, price*i); 
            }else if(e.getSource().equals(dButton4)){
                int i = Integer.valueOf(q14.getText());
                ++i;
                q14.setText(String.valueOf(i));

                String name = dName4.getText();
                int price = Integer.parseInt(dPrice4.getText());

                addTable(name, price, i, price*i);
            }else if(e.getSource().equals(dButton5)){
                int i = Integer.valueOf(q15.getText());
                ++i;
                q15.setText(String.valueOf(i));

                String name = dName5.getText();
                int price = Integer.parseInt(dPrice5.getText());

                addTable(name, price, i, price*i);
            }
            payText.setText("결제 금액 : " + String.valueOf(totalPayment()));
        }
        
    }
    

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bButton1;
    private javax.swing.JButton bButton2;
    private javax.swing.JButton bButton3;
    private javax.swing.JButton bButton4;
    private javax.swing.JButton bButton5;
    private javax.swing.JLabel bName1;
    private javax.swing.JLabel bName2;
    private javax.swing.JLabel bName3;
    private javax.swing.JLabel bName4;
    private javax.swing.JLabel bName5;
    private javax.swing.JLabel bPrice1;
    private javax.swing.JLabel bPrice2;
    private javax.swing.JLabel bPrice3;
    private javax.swing.JLabel bPrice4;
    private javax.swing.JLabel bPrice5;
    private javax.swing.JButton breadBtn;
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton cButton1;
    private javax.swing.JButton cButton2;
    private javax.swing.JButton cButton3;
    private javax.swing.JButton cButton4;
    private javax.swing.JButton cButton5;
    private javax.swing.JLabel cName1;
    private javax.swing.JLabel cName2;
    private javax.swing.JLabel cName3;
    private javax.swing.JLabel cName4;
    private javax.swing.JLabel cName5;
    private javax.swing.JLabel cPrice1;
    private javax.swing.JLabel cPrice2;
    private javax.swing.JLabel cPrice3;
    private javax.swing.JLabel cPrice4;
    private javax.swing.JLabel cPrice5;
    private javax.swing.JButton cakeBtn;
    private javax.swing.JPanel cakePanel;
    private javax.swing.JButton dButton1;
    private javax.swing.JButton dButton2;
    private javax.swing.JButton dButton3;
    private javax.swing.JButton dButton4;
    private javax.swing.JButton dButton5;
    private javax.swing.JLabel dName1;
    private javax.swing.JLabel dName2;
    private javax.swing.JLabel dName3;
    private javax.swing.JLabel dName4;
    private javax.swing.JLabel dName5;
    private javax.swing.JLabel dPrice1;
    private javax.swing.JLabel dPrice2;
    private javax.swing.JLabel dPrice3;
    private javax.swing.JLabel dPrice4;
    private javax.swing.JLabel dPrice5;
    private javax.swing.JButton drinkBtn;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel payText;
    public javax.swing.JLabel q1;
    public javax.swing.JLabel q10;
    public javax.swing.JLabel q11;
    public javax.swing.JLabel q12;
    public javax.swing.JLabel q13;
    public javax.swing.JLabel q14;
    public javax.swing.JLabel q15;
    public javax.swing.JLabel q2;
    public javax.swing.JLabel q3;
    public javax.swing.JLabel q4;
    public javax.swing.JLabel q5;
    public javax.swing.JLabel q6;
    public javax.swing.JLabel q7;
    public javax.swing.JLabel q8;
    public javax.swing.JLabel q9;
    public javax.swing.JTable table;
    public javax.swing.JLabel tableNo;
    // End of variables declaration//GEN-END:variables
}
