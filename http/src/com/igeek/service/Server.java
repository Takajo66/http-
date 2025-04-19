package com.igeek.service;

import com.igeek.data.Data;

import java.net.ServerSocket;
import java.net.Socket;

//监听服务需要一直运行，同时 GUI（图形界面）也要运行，两者不能互相阻塞，所以采用线程。要把Server写成线程类
public class Server implements Runnable{

    //监听端口
    private int port =8088;

    public Server(int port){   //传进来
        this.port=port;
        //port 是服务器监听的端口，通过构造器传入。默认值 8088 只是备用，实际使用会覆盖它。
    }

    @Override
    //线程的主程序 要监听服务
    public void run() {

        //声明ServerSocket对象
        ServerSocket serverSocket=null;
        try{
            //创建ServerSocket对象
            serverSocket=new ServerSocket(port);
            //开始监听
            System.out.println("开始监听（￣︶￣）...");

            while (Data.isRun) {//在允许服务进行的情况下循环监听端口
                Socket accept = serverSocket.accept();//阻塞，等待客户端连接
                System.out.println("接收到请求啦❥(^_-)...");
            }
            //运行到这里程序停止，关闭
            serverSocket.close();
            serverSocket=null;
        }catch(Exception e){//当 try 里的代码出错（比如 new ServerSocket(port) 失败），程序会立即跳到 catch，并把错误信息封装成一个 Exception 对象 e。
            e.printStackTrace();
            //这个信息对调试非常重要，能迅速定位问题出在哪
            throw new RuntimeException("端口"+port+"监听失败"+e.getMessage());
            //手动抛出一个新的异常，让上层程序知道“这里出错了”
        }

    }


    //没有start方法，类自己也没有。创建线程类对象
    public static void main(String[] args) {
        Server server =new Server(8088);//创建线程对象
        //利用Thread启动
        new Thread(server).start();
        //这样可以在一个独立线程中运行服务器逻辑，避免阻塞主界面（MainFrame）。

    }

}
