package com.igeek.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame {
    //组件声明
    //JLabel（标签）
    private JLabel labPort;
    private JLabel labInfo;
    private JLabel labPath;
    //JTeextField文本框
    private JTextField textPort;
    private JTextField textPath;
    //按钮
    private JButton btnStartServer;
    private JButton btnPushServer;
    private JButton btnStopServer;
    private JButton btnSetPath;
    private JPanel contentPanel;

    private JScrollPane scrollPane;//滚动面板
    private JTextArea textArea;//控制台


    public MainFrame(){
    init();
    }

    private void init() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关掉的时候直接关闭程序
        this.setBounds(200, 200, 800, 500);//设置窗口大小
        this.setTitle("\uD83C\uDF38 桃非桃 HTTP 服务器");
        this.setResizable(false);//窗口不能随意改变大小
        Font font = new Font("微软雅黑", Font.PLAIN, 14);
        //设置主面板
        contentPanel = new JPanel();
        contentPanel.setLayout(null);//自己放组件，不根据他的
        contentPanel.setBackground(new Color(245, 248, 250));
        this.setContentPane(contentPanel);
        //端口设置
        labPort = new JLabel("监听的端口号;");
        labPort.setBounds(15, 10, 100, 25);
        labPort.setFont(font);
        contentPanel.add(labPort);

        textPort = new JTextField("8088");//文本框
        textPort.setBounds(120, 10, 120, 25);
        labPort.setFont(font);
        contentPanel.add(textPort);

        //三个按钮
        btnStartServer = new JButton("启动服务器");
        btnStartServer.setBounds(300, 10, 120, 25);
        btnStartServer.setFont(font);
        contentPanel.add(btnStartServer);//将按钮添加到主面板 contentPanel 中

        btnPushServer = new JButton("⏸暂停服务器");
        btnPushServer.setBounds(440, 10, 120, 25);
        btnPushServer.setEnabled(false);//初始状态禁用（false），因为服务未启动时无法暂停
        btnPushServer.setFont(font);
        contentPanel.add(btnPushServer);

        btnStopServer = new JButton("\uD83D\uDED1停止服务");
        btnStopServer.setBounds(580, 10, 120, 25);
        btnStopServer.setEnabled(false);
        btnStopServer.setFont(font);
        contentPanel.add(btnStopServer);

        //资源路径设置
        labPath = new JLabel("资源路径位置:");
        labPath.setBounds(15, 45, 100, 25);
        labPath.setFont(font);
        contentPanel.add(labPath);

        textPath = new JTextField("");
        textPath.setBounds(130, 45, 500, 25);
        textPath.setFont(font);
        contentPanel.add(textPath);

        btnSetPath = new JButton("设置资源位置:");
        btnSetPath.setBounds(640, 45, 120, 25);
        btnSetPath.setFont(font);
        contentPanel.add(btnSetPath);

        //控制台
        textArea = new JTextArea("-古希腊掌管控制的台-\r\n");
        textArea.setLineWrap(true);
        textArea.setFont(font);
        //放滚动条
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//始终显示垂直和水平滚动条
        scrollPane.setBounds(15, 80, 770, 350);
        contentPanel.add(scrollPane);

        //设置资源文件夹按钮事件
        btnSetPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //程序
            }


        });
        //启动按钮事件
        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //程序
            }
        });
        //暂停按钮事件
        btnPushServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //停止按钮事件
        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        this.setVisible(true);//把窗口显示出来
    }



    //输出日志到控制台
        public void printLog (final String[] msg){ //在匿名内部类中使用的参数必须是final的
        //创建新线程
            new Thread(){
                public void run() {
                    String date = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());//定义日期显示格式为[年-月-日 时:分:秒]
                    String info =textArea.getText()+ date+" "+msg+"\r\n";
                    textArea.setText(info);
                }

            }.start();//并且启动
        }
        public static void main(String[] args){
            MainFrame mf =new MainFrame();
        }

    }

