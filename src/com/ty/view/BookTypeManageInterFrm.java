package com.ty.view;

import com.ty.dao.BookTypeDao;
import com.ty.model.BookType;
import com.ty.util.DbUtil;
import com.ty.util.StringUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {
    private JTable bookTypeTable;
    private JTextArea bookTypeDescTxt;

    private DbUtil dbUtil=new DbUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private JTextField s_bookTypeNameTxt;
    private JTextField idTxt;
    private JTextField bookTypeNameTxt;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
    public BookTypeManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
        setBounds(100, 100, 450, 487);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        s_bookTypeNameTxt = new JTextField();
        s_bookTypeNameTxt.setColumns(10);

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTypeSearchActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/query_16px_1075803_easyicon.net.png")));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(35)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33)
                                                .addComponent(button))
                                        .addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                                .addGap(26))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");

        idTxt = new JTextField();
        idTxt.setEditable(false);
        idTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        bookTypeNameTxt = new JTextField();
        bookTypeNameTxt.setColumns(10);

        JLabel label = new JLabel("\u63CF\u8FF0\uFF1A");

        bookTypeDescTxt = new JTextArea();

        JButton button_1 = new JButton("\u4FEE\u6539");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTableUpdateActionEvent(e);
            }
        });
        button_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/edit_pen_pencil_stationery_write_16px_1225486_easyicon.net.png")));

        JButton button_2 = new JButton("\u5220\u9664");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTableDeleteActionEvent(e);
            }
        });
        button_2.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/arrows_remove_16px_1182532_easyicon.net.png")));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_2)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(label)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(bookTypeDescTxt)))
                                                .addContainerGap(18, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                .addComponent(button_1)
                                                .addGap(53)
                                                .addComponent(button_2)
                                                .addGap(64))))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(button_2)
                                        .addComponent(button_1))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        bookTypeTable = new JTable();
        bookTypeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bookTypeTableMousePressed(e);
            }
        });
        bookTypeTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(84);
        bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(85);
        scrollPane.setViewportView(bookTypeTable);
        getContentPane().setLayout(groupLayout);


        this.fillTable(new BookType());

        //设置文本域边框
        bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
    }
    /*
    图书类别删除事件处理，删除一条表单内容操作
     */
    private void bookTableDeleteActionEvent(ActionEvent evt) {
        String id= idTxt.getText();
        if (StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if (n==0){
            Connection connection=null;
            try {
                connection=dbUtil.getCon();
                int delete = bookTypeDao.delete(connection, id);
                if (delete==1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.resetValue();
                    this.fillTable(new BookType());
                }else{
                    JOptionPane.showMessageDialog(null,"删除失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"删除失败");
            }finally {
                try {
                    dbUtil.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    图书类别修改事件处理，修改一条表单内容操作
     */
    private void bookTableUpdateActionEvent(ActionEvent evt) {
        String id= idTxt.getText();
        String bookTypeName = bookTypeNameTxt.getText();
        String bookTypeDesc = bookTypeDescTxt.getText();
        if (StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"请选择要修改的记录");
            return;
        }
        if (StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null,"图书类别名称不能为空");
            return;
        }
        BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
        //实例化对象
        Connection connection=null;
        try{
            connection= dbUtil.getCon();
            int update = bookTypeDao.update(connection, bookType);
            if (update==1){
                JOptionPane.showMessageDialog(null,"修改成功");
                this.resetValue();
                this.fillTable(new BookType());
            }else {
                JOptionPane.showMessageDialog(null,"修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败");
        }finally {
            try {
                dbUtil.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    表格行点击事件处理
     */
    private void bookTypeTableMousePressed(MouseEvent evt) {
        int selectedRow = bookTypeTable.getSelectedRow();
        idTxt.setText((String) bookTypeTable.getValueAt(selectedRow,0));
        bookTypeNameTxt.setText((String) bookTypeTable.getValueAt(selectedRow,1));
        bookTypeDescTxt.setText((String) bookTypeTable.getValueAt(selectedRow,2));
    }

    /*
    图书类别搜索事情处理
     */
    private void bookTypeSearchActionPerformed(ActionEvent evt) {
        String s_bookTypeName = this.s_bookTypeNameTxt.getText();
        BookType bookType = new BookType();
        bookType.setBookTypeName(s_bookTypeName);
        this.fillTable(bookType);
    }

    /*
    初始化表格
     */
    private void fillTable(BookType bookType){
        DefaultTableModel model = (DefaultTableModel) bookTypeTable.getModel();
        model.setRowCount(0);//设置成0行，把表格清空
        /*
        进行数据库查询
         */
        Connection connection=null;
        try {
            connection=dbUtil.getCon();
            ResultSet list = bookTypeDao.list(connection, bookType);
            while (list.next()){
                Vector objects = new Vector();
                objects.add(list.getString("id"));
                objects.add(list.getString("bookTypeName"));
                objects.add(list.getString("bookTypeDesc"));
                model.addRow(objects);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeConnection(connection);//关闭数据库连接
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    重置表单
     */
    private void resetValue(){
        this.idTxt.setText("");
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }
}
