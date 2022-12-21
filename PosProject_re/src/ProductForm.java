import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import DTO.*;

public class ProductForm extends javax.swing.JFrame {
    
    public ProductForm() {
        initComponents();
        setLocationRelativeTo(null);
        /*
         DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); 
         dtcr.setHorizontalAlignment(SwingConstants.CENTER); 
         TableColumnModel tcm = jTable1.getColumnModel() ;
        for(int i = 0 ; i < tcm.getColumnCount() ; i++){
             tcm.getColumn(i).setCellRenderer(dtcr); 
             
        }*/
        
        SetBreadList();
        SetDrinkList();
        SetCakeList();
    }
    
    public ArrayList<BreadDTO> getBreadList(){
        ArrayList<BreadDTO> breadList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "Select * from bread";
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            BreadDTO bread;
            while(rs.next()){
                bread = new BreadDTO(rs.getString("name"), rs.getInt("price"));
                breadList.add(bread);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return breadList;
    }
    
    public ArrayList<DrinkDTO> getDrinkList(){
        ArrayList<DrinkDTO> drinkList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "Select * from drink";
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            DrinkDTO drink;
            while(rs.next()){
                drink = new DrinkDTO(rs.getString("name"), rs.getInt("price"));
                drinkList.add(drink);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return drinkList;
    }
    
    public ArrayList<CakeDTO> getCakeList(){
        ArrayList<CakeDTO> cakeList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "Select * from cake";
        
        try{
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            CakeDTO cake;
            while(rs.next()){
                cake = new CakeDTO(rs.getString("name"), rs.getInt("price"));
                cakeList.add(cake);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return cakeList;
    }
    
    // 테이블에 데이터 Set
    public void SetBreadList(){
        ArrayList<BreadDTO> list = getBreadList();
        
        DefaultTableModel model = (DefaultTableModel) breadTable.getModel();
        model.setNumRows(0);
        Object[] row = new Object[2];
        for(int i=0; i < list.size(); i++){
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            
            model.addRow(row);
        }
       
    }
    
      // 테이블에 데이터 Set
    public void SetDrinkList(){
        ArrayList<DrinkDTO> list = getDrinkList();
        
        DefaultTableModel model = (DefaultTableModel) drinkTable.getModel();
        model.setNumRows(0);
        Object[] row = new Object[2];
        for(int i=0; i < list.size(); i++){
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            
            model.addRow(row);
        }
       
    }
    
      // 테이블에 데이터 Set
    public void SetCakeList(){
        ArrayList<CakeDTO> list = getCakeList();
        
        DefaultTableModel model = (DefaultTableModel) cakeTable.getModel();
        model.setNumRows(0);
        Object[] row = new Object[2];
        for(int i=0; i < list.size(); i++){
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            
            model.addRow(row);
        }
       
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        drinkNameField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAddDrink = new javax.swing.JButton();
        btnUpdateDrink = new javax.swing.JButton();
        btnDelDrink = new javax.swing.JButton();
        drinkPriceField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        drinkTable = new javax.swing.JTable();
        btnBack1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        breadTable = new javax.swing.JTable();
        breadNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAddBread = new javax.swing.JButton();
        btnUpdateBread = new javax.swing.JButton();
        btnDelBread = new javax.swing.JButton();
        breadPrice = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cakeNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAddCake = new javax.swing.JButton();
        btnUpdateCake = new javax.swing.JButton();
        btnDelCake = new javax.swing.JButton();
        cakePriceField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        cakeTable = new javax.swing.JTable();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        pane.setToolTipText("");
        pane.setFont(new java.awt.Font("맑은 고딕", 0, 20)); // NOI18N
        pane.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel9.setBackground(new java.awt.Color(220, 230, 240));

        drinkNameField.setBackground(new java.awt.Color(228, 241, 254));
        drinkNameField.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        drinkNameField.setForeground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("제품명 : ");

        jLabel13.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("가격 : ");

        btnAddDrink.setBackground(new java.awt.Color(34, 167, 240));
        btnAddDrink.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnAddDrink.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDrink.setText("제품 추가");
        btnAddDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDrinkActionPerformed(evt);
            }
        });

        btnUpdateDrink.setBackground(new java.awt.Color(34, 167, 240));
        btnUpdateDrink.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnUpdateDrink.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateDrink.setText("제품 수정");
        btnUpdateDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDrinkActionPerformed(evt);
            }
        });

        btnDelDrink.setBackground(new java.awt.Color(34, 167, 240));
        btnDelDrink.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnDelDrink.setForeground(new java.awt.Color(255, 255, 255));
        btnDelDrink.setText("제품 삭제");
        btnDelDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDrinkActionPerformed(evt);
            }
        });

        drinkPriceField.setBackground(new java.awt.Color(228, 241, 254));
        drinkPriceField.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        drinkPriceField.setForeground(new java.awt.Color(102, 102, 102));

        drinkTable.setFont(new java.awt.Font("빙그레체", 0, 17)); // NOI18N
        drinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "제품명", "제품 가격"
            }
        ));
        drinkTable.setPreferredSize(new java.awt.Dimension(500, 600));
        drinkTable.setRequestFocusEnabled(false);
        drinkTable.setRowHeight(40);
        drinkTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drinkTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(drinkTable);

        btnBack1.setBackground(new java.awt.Color(255, 51, 51));
        btnBack1.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("BACK");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drinkPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                            .addComponent(drinkNameField)))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateDrink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAddDrink, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drinkNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(drinkPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAddDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdateDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pane.addTab("음료", jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(737, 605));

        jPanel6.setBackground(new java.awt.Color(220, 230, 240));

        breadTable.setFont(new java.awt.Font("빙그레체", 0, 15)); // NOI18N
        breadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "제품명", "제품 가격"
            }
        ));
        breadTable.setPreferredSize(new java.awt.Dimension(500, 600));
        breadTable.setRequestFocusEnabled(false);
        breadTable.setRowHeight(40);
        breadTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                breadTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(breadTable);

        breadNameField.setBackground(new java.awt.Color(228, 241, 254));
        breadNameField.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        breadNameField.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("제품명 : ");

        jLabel8.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("가격 : ");

        btnAddBread.setBackground(new java.awt.Color(34, 167, 240));
        btnAddBread.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnAddBread.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBread.setText("제품 추가");
        btnAddBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBreadActionPerformed(evt);
            }
        });

        btnUpdateBread.setBackground(new java.awt.Color(34, 167, 240));
        btnUpdateBread.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnUpdateBread.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBread.setText("제품 수정");
        btnUpdateBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBreadActionPerformed(evt);
            }
        });

        btnDelBread.setBackground(new java.awt.Color(34, 167, 240));
        btnDelBread.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnDelBread.setForeground(new java.awt.Color(255, 255, 255));
        btnDelBread.setText("제품 삭제");
        btnDelBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelBreadActionPerformed(evt);
            }
        });

        breadPrice.setBackground(new java.awt.Color(228, 241, 254));
        breadPrice.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        breadPrice.setForeground(new java.awt.Color(102, 102, 102));

        btnBack.setBackground(new java.awt.Color(255, 51, 51));
        btnBack.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(breadPrice)
                            .addComponent(breadNameField)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateBread, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelBread, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAddBread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(breadNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(breadPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddBread, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdateBread, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelBread, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pane.addTab("빵", jPanel4);

        jPanel8.setBackground(new java.awt.Color(220, 230, 240));

        cakeNameField.setBackground(new java.awt.Color(228, 241, 254));
        cakeNameField.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        cakeNameField.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("제품명 : ");

        jLabel11.setFont(new java.awt.Font("빙그레체", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("가격 : ");

        btnAddCake.setBackground(new java.awt.Color(34, 167, 240));
        btnAddCake.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnAddCake.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCake.setText("제품 추가");
        btnAddCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCakeActionPerformed(evt);
            }
        });

        btnUpdateCake.setBackground(new java.awt.Color(34, 167, 240));
        btnUpdateCake.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnUpdateCake.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCake.setText("제품 수정");
        btnUpdateCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCakeActionPerformed(evt);
            }
        });

        btnDelCake.setBackground(new java.awt.Color(34, 167, 240));
        btnDelCake.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnDelCake.setForeground(new java.awt.Color(255, 255, 255));
        btnDelCake.setText("제품 삭제");
        btnDelCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCakeActionPerformed(evt);
            }
        });

        cakePriceField.setBackground(new java.awt.Color(228, 241, 254));
        cakePriceField.setFont(new java.awt.Font("맑은 고딕", 0, 17)); // NOI18N
        cakePriceField.setForeground(new java.awt.Color(102, 102, 102));

        cakeTable.setFont(new java.awt.Font("빙그레체", 0, 17)); // NOI18N
        cakeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "제품명", "제품 가격"
            }
        ));
        cakeTable.setPreferredSize(new java.awt.Dimension(500, 700));
        cakeTable.setRequestFocusEnabled(false);
        cakeTable.setRowHeight(40);
        cakeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cakeTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(cakeTable);

        btnBack2.setBackground(new java.awt.Color(255, 51, 51));
        btnBack2.setFont(new java.awt.Font("빙그레체", 1, 16)); // NOI18N
        btnBack2.setForeground(new java.awt.Color(255, 255, 255));
        btnBack2.setText("BACK");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cakePriceField)
                            .addComponent(cakeNameField)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateCake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelCake, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAddCake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cakeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cakePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAddCake, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdateCake, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelCake, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pane.addTab("케잌", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAddBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBreadActionPerformed
        String name =breadNameField.getText();
        String price = breadPrice.getText();
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from bread where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행

            if(rs.next()) { //ID가 중복되면
                showMessageDialog(null, "이미 존재하는 상품 입니다.");
                return;
            }else {
                //중복이안됐을때
                String SQL = "INSERT INTO BREAD VALUES (?, ?)";
                try{
                    if(name.equals("")){
                        showMessageDialog(null, "상품명을 입력해 주세요");
                        return;
                    }else if(price.equals("")){
                        showMessageDialog(null, "상품 가격을 입력해 주세요");
                        return;
                    }else{
                        pstmt = conn.prepareStatement(SQL);
                        pstmt.setString(1, name);
                        pstmt.setInt(2, Integer.parseInt(price));
                        pstmt.executeUpdate();
                        showMessageDialog(null, "제품이 추가 되었습니다.");
                        SetBreadList();
                    }
                }catch(Exception e) { e.printStackTrace(); }}
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        breadNameField.setText("");
        breadPrice.setText("");
    }//GEN-LAST:event_btnAddBreadActionPerformed

    private void btnAddCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCakeActionPerformed
        String name =cakeNameField.getText();
        String price = cakePriceField.getText();
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from cake where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행

            if(rs.next()) { //ID가 중복되면
                showMessageDialog(null, "이미 존재하는 상품 입니다.");
                return;
            }else {
                //중복이안됐을때
                String SQL = "INSERT INTO CAKE VALUES (?, ?)";
                try{
                    if(name.equals("")){
                        showMessageDialog(null, "상품명을 입력해 주세요");
                        return;
                    }else if(price.equals("")){
                        showMessageDialog(null, "상품 가격을 입력해 주세요");
                        return;
                    }else{
                        pstmt = conn.prepareStatement(SQL);
                        pstmt.setString(1, name);
                        pstmt.setInt(2, Integer.parseInt(price));
                        pstmt.executeUpdate();
                        showMessageDialog(null, "제품이 추가 되었습니다.");
                        SetCakeList();
                    }
                }catch(Exception e) { e.getMessage(); }}
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        cakeNameField.setText("");
        cakePriceField.setText("");
    }//GEN-LAST:event_btnAddCakeActionPerformed

    private void btnAddDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDrinkActionPerformed
        String name =drinkNameField.getText();
        String price = drinkPriceField.getText();
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from drink where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행

            if(rs.next()) { //ID가 중복되면
                showMessageDialog(null, "이미 존재하는 상품 입니다.");
                return;
            }else {
                //중복이안됐을때
                String SQL = "INSERT INTO DRINK VALUES (?, ?)";
                try{
                    if(name.equals("")){
                        showMessageDialog(null, "상품명을 입력해 주세요");
                        return;
                    }else if(price.equals("")){
                        showMessageDialog(null, "상품 가격을 입력해 주세요");
                        return;
                    }else{
                        pstmt = conn.prepareStatement(SQL);
                        pstmt.setString(1, name);
                        pstmt.setInt(2, Integer.parseInt(price));
                        pstmt.executeUpdate();
                        showMessageDialog(null, "제품이 추가 되었습니다.");
                        SetDrinkList();
                    }
                }catch(Exception e) { e.getMessage(); }}
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        drinkNameField.setText("");
        drinkPriceField.setText("");
    }//GEN-LAST:event_btnAddDrinkActionPerformed

    private void drinkTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drinkTableMouseClicked
        int rowCnt = drinkTable.getSelectedRow();
        drinkNameField.setText(drinkTable.getValueAt(rowCnt, 0).toString());
        drinkPriceField.setText(drinkTable.getValueAt(rowCnt, 1).toString());
    }//GEN-LAST:event_drinkTableMouseClicked

    private void breadTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_breadTableMouseClicked
        int rowCnt = breadTable.getSelectedRow();
        breadNameField.setText(breadTable.getValueAt(rowCnt, 0).toString());
        breadPrice.setText(breadTable.getValueAt(rowCnt, 1).toString());
    }//GEN-LAST:event_breadTableMouseClicked

    private void cakeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cakeTableMouseClicked
        int rowCnt = cakeTable.getSelectedRow();
        cakeNameField.setText(cakeTable.getValueAt(rowCnt, 0).toString());
        cakePriceField.setText(cakeTable.getValueAt(rowCnt, 1).toString());
    }//GEN-LAST:event_cakeTableMouseClicked

    private void btnUpdateBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBreadActionPerformed
        String name = breadNameField.getText();
        String price = breadPrice.getText();
        int CntRow = breadTable.getSelectedRow();
        String preName = breadTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from bread where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행

           
                
                String SQL = "UPDATE BREAD SET NAME=?, BREADPRICE=? WHERE NAME=?";
                pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, name);
                pstmt.setInt(2, Integer.parseInt(price));
                pstmt.setString(3, preName);
                int result = pstmt.executeUpdate();
                
                if(result > 0) showMessageDialog(null, "수정이 완료 되었습니다.");
                else showMessageDialog(null, "수정 실패");
                SetBreadList();
                breadNameField.setText("");
                breadPrice.setText("");
            
        }catch(Exception e){System.out.println(e.getMessage());}
        
    }//GEN-LAST:event_btnUpdateBreadActionPerformed

    private void btnUpdateDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDrinkActionPerformed
        String name = drinkNameField.getText();
        String price = drinkPriceField.getText();
        int CntRow = drinkTable.getSelectedRow();
        String preName = drinkTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from drink where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행
            
                
                String SQL = "UPDATE DRINK SET NAME=?, DRINKPRICE=? WHERE NAME=?";
                pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, name);
                pstmt.setInt(2, Integer.parseInt(price));
                pstmt.setString(3, preName);
                int result = pstmt.executeUpdate();
                
                if(result > 0) showMessageDialog(null, "수정이 완료 되었습니다.");
                else showMessageDialog(null, "수정 실패");
                SetDrinkList();
                drinkNameField.setText("");
                drinkPriceField.setText("");
            
        }catch(Exception e){System.out.println(e.getMessage());}
    }//GEN-LAST:event_btnUpdateDrinkActionPerformed

    private void btnUpdateCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCakeActionPerformed
        String name = cakeNameField.getText();
        String price = cakePriceField.getText();
        int CntRow = cakeTable.getSelectedRow();
        String preName = cakeTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        ResultSet rs= null;
        try{
            conn = DBconnection.getConnection();
            String sql = "select * from cake where name = ?"; //Select 문 사용해서 ID가 있는지 확인
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name); //String sql에 있는 ?에 첫번째 값을 id로
            rs = pstmt.executeQuery(); //select 문은 executeQuery , rs = pstmt.executeQuery SQL문에 결과값이 있으면 true , 그래서 rs.next 그줄 실행
                
            String SQL = "UPDATE CAKE SET NAME=?, CAKEPRICE=? WHERE NAME=?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(price));
            pstmt.setString(3, preName);
            int result = pstmt.executeUpdate();

            if(result > 0) showMessageDialog(null, "수정이 완료 되었습니다.");
            else showMessageDialog(null, "수정 실패");
            SetCakeList();
            cakeNameField.setText("");
            cakePriceField.setText("");
            
        }catch(Exception e){System.out.println(e.getMessage());}
    }//GEN-LAST:event_btnUpdateCakeActionPerformed

    private void btnDelDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDrinkActionPerformed

        int CntRow = drinkTable.getSelectedRow();
        String preName = drinkTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        
        try{
            String SQL = "DELETE FROM DRINK WHERE NAME=?";
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, preName);
            int result = pstmt.executeUpdate();

            if(result > 0) showMessageDialog(null, "삭제가 완료 되었습니다.");
            
            SetDrinkList();
            drinkNameField.setText("");
            drinkPriceField.setText("");
        }catch(Exception e){System.out.println(e.getMessage());}
    }//GEN-LAST:event_btnDelDrinkActionPerformed

    private void btnDelCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCakeActionPerformed
        int CntRow = cakeTable.getSelectedRow();
        String preName = cakeTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        
        try{
            String SQL = "DELETE FROM CAKE WHERE NAME=?";
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, preName);
            int result = pstmt.executeUpdate();

            if(result > 0) showMessageDialog(null, "삭제가 완료 되었습니다.");
            
            SetCakeList();
            cakeNameField.setText("");
            cakePriceField.setText("");
        }catch(Exception e){System.out.println(e.getMessage());}
    }//GEN-LAST:event_btnDelCakeActionPerformed

    private void btnDelBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelBreadActionPerformed
        int CntRow = breadTable.getSelectedRow();
        String preName = breadTable.getValueAt(CntRow, 0).toString();
        
        Connection conn = null;
        PreparedStatement pstmt  = null;
        
        try{
            String SQL = "DELETE FROM BREAD WHERE NAME=?";
            conn = DBconnection.getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, preName);
            int result = pstmt.executeUpdate();

            if(result > 0) showMessageDialog(null, "삭제가 완료 되었습니다.");
            
            SetBreadList();
            breadNameField.setText("");
            breadPrice.setText("");
        }catch(Exception e){System.out.println(e.getMessage());}
    }//GEN-LAST:event_btnDelBreadActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        TableForm tf = new TableForm();
        tf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        TableForm tf = new TableForm();
        tf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        TableForm tf = new TableForm();
        tf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBack2ActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductForm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField breadNameField;
    private javax.swing.JTextField breadPrice;
    private javax.swing.JTable breadTable;
    private javax.swing.JButton btnAddBread;
    private javax.swing.JButton btnAddCake;
    private javax.swing.JButton btnAddDrink;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDelBread;
    private javax.swing.JButton btnDelCake;
    private javax.swing.JButton btnDelDrink;
    private javax.swing.JButton btnUpdateBread;
    private javax.swing.JButton btnUpdateCake;
    private javax.swing.JButton btnUpdateDrink;
    private javax.swing.JTextField cakeNameField;
    private javax.swing.JTextField cakePriceField;
    private javax.swing.JTable cakeTable;
    private javax.swing.JTextField drinkNameField;
    private javax.swing.JTextField drinkPriceField;
    private javax.swing.JTable drinkTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane pane;
    // End of variables declaration//GEN-END:variables
}
