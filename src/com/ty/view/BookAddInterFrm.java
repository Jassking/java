package com.ty.view;

import com.ty.dao.BookDao;
import com.ty.dao.BookTypeDao;
import com.ty.model.Book;
import com.ty.model.BookType;
import com.ty.util.DbUtil;
import com.ty.util.StringUtil;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
    private JTextField bookNameTxt;
    private JTextField authorTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField priceTxt;

    private DbUtil dbUtil=new DbUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private BookDao bookDao =new BookDao();

    private JComboBox bookTypeJcb ;
    private JTextArea bookDescTxt ;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookAddInterFrm frame = new BookAddInterFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookAddInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u6DFB\u52A0");
        setBounds(100, 100, 450, 479);

        JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);

        JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

        authorTxt = new JTextField();
        authorTxt.setColumns(10);

        JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);

        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        JLabel label_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");

        priceTxt = new JTextField();
        priceTxt.setColumns(10);

        JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

        bookDescTxt = new JTextArea();

        JLabel label_5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

        bookTypeJcb = new JComboBox();

        JButton button = new JButton("\u6DFB\u52A0");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookAddActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add_15.0784px_1231419_easyicon.net.png")));

        JButton button_1 = new JButton("\u91CD\u7F6E");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/circular_arrows_17.941333333333px_1197059_easyicon.net.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(31)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(label_4)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label_2)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(manJrb)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(femaleJrb))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label_5)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(27)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label_1)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label_3)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))))
                                .addGap(41))
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap(111, Short.MAX_VALUE)
                                .addComponent(button)
                                .addGap(80)
                                .addComponent(button_1)
                                .addGap(91))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(47)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1)
                                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_2)
                                        .addComponent(manJrb)
                                        .addComponent(femaleJrb)
                                        .addComponent(label_3)
                                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_5)
                                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(41)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(button_1)
                                        .addComponent(button))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        //设置文本域边框
        bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

        fillBookType();
    }
    private void resetValueActionPerformed(ActionEvent e) {
        this.resetValue();
    }

    /*
    图书添加事件处理
     */
    private void bookAddActionPerformed(ActionEvent evt) {
        String bookName = this.bookNameTxt.getText();
        String author = this.authorTxt.getText();
        String price = this.priceTxt.getText();
        String bookDesc = this.bookDescTxt.getText();

        if (StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null,"图书名称不能为空！");
            return;
        }

        if (StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null,"图书作者不能为空！");
            return;
        }

        if (StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null,"图书价格不能为空！");
            return;
        }

        String sex="";
        if (manJrb.isSelected()){//isSelected()假如选中这赋值
            sex="男";
        }else if (femaleJrb.isSelected()){
            sex="女";
        }

        BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(bookName,author,sex,Float.parseFloat(price),bookTypeId,bookDesc);

        Connection connection=null;
        try{
            connection=dbUtil.getCon();
            int add = bookDao.add(connection, book);
            if (add==1){
                JOptionPane.showMessageDialog(null,"图书添加成功！");
                resetValue();
            }else {
                JOptionPane.showMessageDialog(null,"图书添加失败！");
            }

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"图书添加失败！");
        }finally {
            try {
                dbUtil.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    重置表单
     */
    private void resetValue(){
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if (this.bookTypeJcb.getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
        }
    }

    /*
初始化图书类别下拉框
 */
    private void fillBookType(){
        Connection connection=null;
        BookType bookType=null;
        try{
            connection=dbUtil.getCon();
            ResultSet list = bookTypeDao.list(connection, new BookType());
            while (list.next()){
                bookType =new BookType();
                bookType.setId(list.getInt("id"));
                bookType.setBookTypeName(list.getString("bookTypeName"));
                this.bookTypeJcb.addItem(bookType);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
