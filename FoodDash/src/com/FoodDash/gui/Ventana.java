package com.FoodDash.gui;

import com.FoodDash.dao.RestaurantDAOImpl;
import com.FoodDash.entities.Restaurant;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Ventana extends javax.swing.JFrame
{
    public Ventana()
    {
        initComponents();
        this.setMinimumSize(new Dimension(300,400));
        restaurantList.setModel(listModel);
        updateRestaurantList();
        this.setLocationRelativeTo(null);
    }

    DefaultListModel listModel = new DefaultListModel();
    Restaurant selectedRestaurant;
    String[] pedido;
    int menuItems = 5;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaymentMethodButtons = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        content = new javax.swing.JLayeredPane();
        restaurantPanel = new javax.swing.JPanel();
        restaurantTitleLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantList = new javax.swing.JList<>();
        seeMenuBtn = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        menuTitleLbl = new javax.swing.JLabel();
        orderBtn = new javax.swing.JButton();
        backToRestaurantBtn = new javax.swing.JButton();
        menuScroll = new javax.swing.JScrollPane();
        menuBg = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        addrLbl = new javax.swing.JLabel();
        phoneLbl = new javax.swing.JLabel();
        cardNumberLbl = new javax.swing.JLabel();
        expiryDateLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        addrTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        cardNumberTxt = new javax.swing.JTextField();
        expiryDateTxt = new javax.swing.JTextField();
        forwardBtn = new javax.swing.JButton();
        backToMenuBtn = new javax.swing.JButton();
        cardInfoSeparator = new javax.swing.JSeparator();
        cardButton = new javax.swing.JRadioButton();
        cashButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        orderInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        orderCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("URW Gothic", 0, 24)); // NOI18N
        titleLabel.setText("FoodDash");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titleLabel)
                .addGap(16, 16, 16))
        );

        restaurantPanel.setBackground(new java.awt.Color(255, 255, 255));

        restaurantTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restaurantTitleLbl.setText("Restaurants");

        restaurantList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(restaurantList);

        seeMenuBtn.setText("Ver menu");
        seeMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout restaurantPanelLayout = new javax.swing.GroupLayout(restaurantPanel);
        restaurantPanel.setLayout(restaurantPanelLayout);
        restaurantPanelLayout.setHorizontalGroup(
            restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, restaurantPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(seeMenuBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restaurantTitleLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        restaurantPanelLayout.setVerticalGroup(
            restaurantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, restaurantPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaurantTitleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seeMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuTitleLbl.setText("Menu de ...");

        orderBtn.setText("Pedir");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        backToRestaurantBtn.setForeground(new java.awt.Color(255, 255, 255));
        backToRestaurantBtn.setText("<");
        backToRestaurantBtn.setBackground(Color.RED);
        backToRestaurantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToRestaurantBtnActionPerformed(evt);
            }
        });

        menuBg.setBackground(new java.awt.Color(255, 255, 255));
        menuBg.setLayout(new java.awt.GridLayout(menuItems, 2));
        menuScroll.setViewportView(menuBg);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuScroll)
                    .addComponent(menuTitleLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(backToRestaurantBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTitleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuScroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backToRestaurantBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        nameLbl.setText("Nombre");

        addrLbl.setText("Direccion");

        phoneLbl.setText("Telefono");

        cardNumberLbl.setText("Numero de tarjeta");

        expiryDateLbl.setText("Fecha de expiracion");

        forwardBtn.setText("Continuar con el pedido");
        forwardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardBtnActionPerformed(evt);
            }
        });

        backToMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        backToMenuBtn.setText("<");
        backToMenuBtn.setBackground(Color.RED);
        backToMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuBtnActionPerformed(evt);
            }
        });

        PaymentMethodButtons.add(cardButton);
        cardButton.setSelected(true);
        cardButton.setText("Tarjeta");
        cardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtonActionPerformed(evt);
            }
        });

        PaymentMethodButtons.add(cashButton);
        cashButton.setText("Efectivo");
        cashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashButtonActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Metodo de pago");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardInfoSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addComponent(backToMenuBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardNumberLbl)
                            .addComponent(phoneLbl)
                            .addComponent(addrLbl)
                            .addComponent(nameLbl)
                            .addComponent(expiryDateLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTxt)
                            .addComponent(addrTxt)
                            .addComponent(phoneTxt)
                            .addComponent(cardNumberTxt)
                            .addComponent(expiryDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(cashButton)
                                .addGap(10, 10, 10)
                                .addComponent(cardButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addrLbl)
                    .addComponent(addrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(cardInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberLbl)
                    .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expiryDateLbl)
                    .addComponent(expiryDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButton)
                    .addComponent(cashButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        orderInfoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Order Info");

        orderCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        orderCancelButton.setText("Cancelar pedido");
        orderCancelButton.setBackground(Color.RED);
        orderCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderInfoPanelLayout = new javax.swing.GroupLayout(orderInfoPanel);
        orderInfoPanel.setLayout(orderInfoPanelLayout);
        orderInfoPanelLayout.setHorizontalGroup(
            orderInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderCancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderInfoPanelLayout.setVerticalGroup(
            orderInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(orderCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        content.add(restaurantPanel, new Integer(3));
        content.add(menuPanel, new Integer(2));
        content.add(loginPanel, new Integer(1));
        content.add(orderInfoPanel, new Integer(0));

        content.setLayer(restaurantPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        content.setLayer(menuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        content.setLayer(loginPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        content.setLayer(orderInfoPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurantPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(orderInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurantPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(orderInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToRestaurantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToRestaurantBtnActionPerformed
        content.moveToFront(restaurantPanel);
    }//GEN-LAST:event_backToRestaurantBtnActionPerformed

    private void seeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeMenuBtnActionPerformed
        if(selectRestaurant())
        {
            menuTitleLbl.setText("Menu de "+selectedRestaurant.getNombre());
            content.moveToFront(menuPanel);
        }
    }//GEN-LAST:event_seeMenuBtnActionPerformed

    private void backToMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuBtnActionPerformed
        content.moveToFront(menuPanel);
    }//GEN-LAST:event_backToMenuBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        content.moveToFront(loginPanel);
    }//GEN-LAST:event_orderBtnActionPerformed

    private void forwardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardBtnActionPerformed
        content.moveToFront(orderInfoPanel);
    }//GEN-LAST:event_forwardBtnActionPerformed

    private void cashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashButtonActionPerformed
        hideCardInfo(true);
    }//GEN-LAST:event_cashButtonActionPerformed

    private void cardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtonActionPerformed
        hideCardInfo(false);
    }//GEN-LAST:event_cardButtonActionPerformed

    private void orderCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCancelButtonActionPerformed
        JOptionPane.showMessageDialog(this, "El pedido fue exitosamente cancelado", "Pedido alterado", JOptionPane.INFORMATION_MESSAGE);
        content.moveToFront(restaurantPanel);
    }//GEN-LAST:event_orderCancelButtonActionPerformed

    private void updateRestaurantList()
    {
        listModel.addAll(RestaurantDAOImpl.getRestaurantList());
    }
    
    private boolean selectRestaurant()
    {
        try
        {
        selectedRestaurant = (Restaurant) listModel.getElementAt(restaurantList.getSelectedIndex());
        System.out.println(selectedRestaurant.getNombre());
        }
        catch(IndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(this, "No se selecciono ninguna opcion", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void hideCardInfo(boolean b)
    {
        b = !b;
        cardNumberLbl.setEnabled(b);
        cardNumberTxt.setEnabled(b);
        expiryDateLbl.setEnabled(b);
        expiryDateTxt.setEnabled(b);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup PaymentMethodButtons;
    private javax.swing.JLabel addrLbl;
    private javax.swing.JTextField addrTxt;
    private javax.swing.JButton backToMenuBtn;
    private javax.swing.JButton backToRestaurantBtn;
    private javax.swing.JRadioButton cardButton;
    private javax.swing.JSeparator cardInfoSeparator;
    private javax.swing.JLabel cardNumberLbl;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JRadioButton cashButton;
    private javax.swing.JLayeredPane content;
    private javax.swing.JLabel expiryDateLbl;
    private javax.swing.JTextField expiryDateTxt;
    private javax.swing.JButton forwardBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel menuBg;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JScrollPane menuScroll;
    private javax.swing.JLabel menuTitleLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton orderCancelButton;
    private javax.swing.JPanel orderInfoPanel;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JList<String> restaurantList;
    private javax.swing.JPanel restaurantPanel;
    private javax.swing.JLabel restaurantTitleLbl;
    private javax.swing.JButton seeMenuBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}