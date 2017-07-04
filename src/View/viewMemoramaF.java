/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class viewMemoramaF extends javax.swing.JFrame {

    JButton botones[] = new JButton[20]; //arreglo de botones
    int imagenes2[] = new int[20]; //arreglo de imagenes
    int repetidos[] = new int[10]; //arreglo de repetidos
    int parejas[] = new int[20]; //arreglo de parejas
    int cantClick[] = new int[20]; //arreglo de clicks

    int turno;
    int pares1 = 0;
    int pares2 = 0;
    int vista1 = 0; //vista1
    int vista2 = 0; //vista2
    int click = 0;
    int ganar=0;

    /**
     * Creates new form viewMemorama
     */
    public void ganador() {
        String g1 = labelPar1.getText();
        String g2 = labelPar2.getText();

        int gan1 = Integer.parseInt(g1);
        int gan2 = Integer.parseInt(g2);

        if (ganar == 10) {
            if (gan1 == gan2) {
                this.setVisible(false);
                ganadorE ganaE = new ganadorE();
                ganaE.setVisible(true);
            }
            if (gan1 > gan2) {
                this.setVisible(false);
                ganador1 gana1 = new ganador1();
                gana1.setVisible(true);
            }
            if (gan1 < gan2) {
                this.setVisible(false);
                ganador2 gana2 = new ganador2();
                gana2.setVisible(true);
            }

        }
    }
    
    public viewMemoramaF() {
        initComponents();
        Centrar();
        txtPlayer2.setBackground(Color.GRAY);
        iniciarArreglo();
        String nom1 = JOptionPane.showInputDialog("Ingresar Nombre 1");
        txtPlayer1.setText(nom1);
        txtPlayer1.setEditable(false);
        txtPlayer1.setBackground(Color.yellow);
        String nom2 = JOptionPane.showInputDialog("Ingresa el nombre 2");
        txtPlayer2.setText(nom2);
        txtPlayer2.setEditable(false);
        txtPlayer1.setBackground(Color.yellow);
        int turno = 0;
    }
    
    private void Centrar(){
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension ventana = this.getSize();
            double posX = (pantalla.getWidth() - ventana.getWidth())/2.0;
            double posY = (pantalla.getHeight() - ventana.getHeight())/2.0;
            this.setLocation((int) posX, (int) posY);
        }
    
    private void iniciarArreglo(){
        iniciarImagenes();
        
        iniciarCero(imagenes2);
        iniciarCero(repetidos);
        iniciarCero(parejas);
        iniciarCero(cantClick);
         
        int posicionIma;
        Random Random = new Random();
        
        for(int i = 0; i < imagenes2.length; i++){
            posicionIma = Random.nextInt(10);
            
            if(repetidos[posicionIma]<2){
                imagenes2[i] = posicionIma+1;
                repetidos[posicionIma]++;
            }else{
                i--;
            }
        }
    }
    
    private void iniciarCero(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++){
            arreglo[i] = 0;
        }
    }
    
    private void iniciarImagenes(){
        botones[0] = button1;
        botones[1] = button2;
        botones[2] = button3;
        botones[3] = button4;
        botones[4] = button5;
        botones[5] = button6;
        botones[6] = button7;
        botones[7] = button8;
        botones[8] = button9;
        botones[9] = button10;
        botones[10] = button11;
        botones[11] = button12;
        botones[12] = button13;
        botones[13] = button14;
        botones[14] = button15;
        botones[15] = button16;
        botones[16] = button17;
        botones[17] = button18;
        botones[18] = button19;
        botones[19] = button20;
        
        for (int i = 0; i < botones.length; i++){
            botones[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png")));
        }
        
    }
    
    private void parejas(int vista1, int vista2) {
        if (imagenes2[vista1] == imagenes2[vista2]) {

            if (!(turno == 1)) {
                pares1++;
                labelPar1.setText(pares1 + "");
                ganar++;
                ganador();

            } else {
                pares2++;
                labelPar2.setText(pares2 + "");
                ganar++;
                ganador();

            }

            parejas[vista1] = 1;
            parejas[vista2] = 1;
        } else {
            botones[vista1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png")));
            botones[vista2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png")));
            cantClick[vista1] = 0;
            cantClick[vista2] = 0;
            if (turno == 1) {
                txtPlayer1.setBackground(Color.YELLOW);
                txtPlayer2.setBackground(Color.GRAY);
                turno = 0;
            } else {
                txtPlayer2.setBackground(Color.RED);
                txtPlayer1.setBackground(Color.GRAY);
                turno = 1;
            }
        }
    }
    
   
        
    private void accion3(java.awt.event.ActionEvent evt){
        for (int i = 0; i < botones.length; i++){
            if (evt.getSource() == botones[i] && parejasEncontradas(i)){
                cantClick[i]++;
                if(cantClick[i] < 2){
                    click++;
                    botones[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesFamosos/f" + imagenes2[i] + ".png")));
                    if(click == 1){
                        vista1 = i;
                    }else{
                        vista2 = i;
                    }
                }
            }
        }
    }
    
    private void accion4(java.awt.event.MouseEvent evt){
      for (int i = 0; i < botones.length; i++) {
            if (evt.getSource() == botones[i]) {
                if (click >= 2) {
                    parejas(vista1, vista2);
                    click = 0;
                }
            }

        }

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelPar1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelPar2 = new javax.swing.JLabel();
        txtPlayer1 = new javax.swing.JTextField();
        txtPlayer2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button10 = new javax.swing.JButton();
        button11 = new javax.swing.JButton();
        button12 = new javax.swing.JButton();
        button13 = new javax.swing.JButton();
        button14 = new javax.swing.JButton();
        button15 = new javax.swing.JButton();
        button16 = new javax.swing.JButton();
        button17 = new javax.swing.JButton();
        button18 = new javax.swing.JButton();
        button19 = new javax.swing.JButton();
        button20 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Famosos");

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        jLabel2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 1");
        jLabel2.setToolTipText("");
        jLabel2.setOpaque(true);

        labelPar1.setBackground(new java.awt.Color(102, 102, 255));
        labelPar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPar1.setText("0");
        labelPar1.setToolTipText("");
        labelPar1.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(51, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Player 2");
        jLabel4.setToolTipText("");
        jLabel4.setOpaque(true);

        labelPar2.setBackground(new java.awt.Color(102, 102, 255));
        labelPar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPar2.setText("0");
        labelPar2.setOpaque(true);

        txtPlayer2.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPlayer2)
                    .addComponent(labelPar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPlayer1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(labelPar2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Juego de Memorama");
        jLabel6.setToolTipText("");

        jButton1.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(141, 141, 141)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(4, 5));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel5.add(button1);

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2MouseExited(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel5.add(button2);

        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button3MouseExited(evt);
            }
        });
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel5.add(button3);

        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button4MouseExited(evt);
            }
        });
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel5.add(button4);

        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button5MouseExited(evt);
            }
        });
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        jPanel5.add(button5);

        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button6MouseExited(evt);
            }
        });
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        jPanel5.add(button6);

        button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button7MouseExited(evt);
            }
        });
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        jPanel5.add(button7);

        button8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button8MouseExited(evt);
            }
        });
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        jPanel5.add(button8);

        button9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button9MouseExited(evt);
            }
        });
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });
        jPanel5.add(button9);

        button10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button10MouseExited(evt);
            }
        });
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });
        jPanel5.add(button10);

        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button11MouseExited(evt);
            }
        });
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });
        jPanel5.add(button11);

        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button12MouseExited(evt);
            }
        });
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });
        jPanel5.add(button12);

        button13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button13MouseExited(evt);
            }
        });
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });
        jPanel5.add(button13);

        button14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button14MouseExited(evt);
            }
        });
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });
        jPanel5.add(button14);

        button15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button15MouseExited(evt);
            }
        });
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });
        jPanel5.add(button15);

        button16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button16MouseExited(evt);
            }
        });
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button16ActionPerformed(evt);
            }
        });
        jPanel5.add(button16);

        button17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button17MouseExited(evt);
            }
        });
        button17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button17ActionPerformed(evt);
            }
        });
        jPanel5.add(button17);

        button18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button18MouseExited(evt);
            }
        });
        button18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button18ActionPerformed(evt);
            }
        });
        jPanel5.add(button18);

        button19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button19MouseExited(evt);
            }
        });
        button19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button19ActionPerformed(evt);
            }
        });
        jPanel5.add(button19);

        button20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/bloqueMario.png"))); // NOI18N
        button20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button20MouseExited(evt);
            }
        });
        button20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button20ActionPerformed(evt);
            }
        });
        jPanel5.add(button20);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Juego");
        jMenu1.setToolTipText("");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("categorias");

        jMenuItem1.setText("Famosos");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Animales");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        Exit.setText("Salir");
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(Exit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button8ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button7ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button9ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button10ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button12ActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button13ActionPerformed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button14ActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button15ActionPerformed

    private void button16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button16ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button16ActionPerformed

    private void button17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button17ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button17ActionPerformed

    private void button18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button18ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button18ActionPerformed

    private void button19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button19ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button19ActionPerformed

    private void button20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button20ActionPerformed
        // TODO add your handling code here:
        accion3(evt);
    }//GEN-LAST:event_button20ActionPerformed

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button1MouseExited

    private void button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button2MouseExited

    private void button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button3MouseExited

    private void button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button4MouseExited

    private void button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button5MouseExited

    private void button6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button6MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button6MouseExited

    private void button7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button7MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button7MouseExited

    private void button8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button8MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button8MouseExited

    private void button9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button9MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button9MouseExited

    private void button10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button10MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button10MouseExited

    private void button11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button11MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button11MouseExited

    private void button12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button12MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button12MouseExited

    private void button13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button13MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button13MouseExited

    private void button14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button14MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button14MouseExited

    private void button15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button15MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button15MouseExited

    private void button16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button16MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button16MouseExited

    private void button17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button17MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button17MouseExited

    private void button18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button18MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button18MouseExited

    private void button19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button19MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button19MouseExited

    private void button20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button20MouseExited
        // TODO add your handling code here:
        accion4(evt);
    }//GEN-LAST:event_button20MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        gamePrincipal g1 = new gamePrincipal();
        g1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(viewMemoramaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMemoramaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMemoramaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMemoramaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewMemoramaF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Exit;
    private javax.swing.JButton button1;
    private javax.swing.JButton button10;
    private javax.swing.JButton button11;
    private javax.swing.JButton button12;
    private javax.swing.JButton button13;
    private javax.swing.JButton button14;
    private javax.swing.JButton button15;
    private javax.swing.JButton button16;
    private javax.swing.JButton button17;
    private javax.swing.JButton button18;
    private javax.swing.JButton button19;
    private javax.swing.JButton button2;
    private javax.swing.JButton button20;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelPar1;
    private javax.swing.JLabel labelPar2;
    private javax.swing.JTextField txtPlayer1;
    private javax.swing.JTextField txtPlayer2;
    // End of variables declaration//GEN-END:variables

    private boolean parejasEncontradas(int i){
        if (parejas[i] !=1){
            return true;
        }else{
            return false;
        }
    }
}

