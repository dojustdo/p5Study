package com.study.io.disk;

import java.io.*;

/**
 * @author dxq
 * @title: ObjectReaderWriterDemo
 * @projectName reflex
 * @description: 流的方式序列化，反序列化
 * @date 2020/3/6 16:36
 */
public class ObjectReaderWriterDemo {

    public static class User implements Serializable {
        private String name;
        private String ago;

        public User(String name, String ago) {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAgo() {
            return ago;
        }

        public void setAgo(String ago) {
            this.ago = ago;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", ago='" + ago + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        /*try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("D:/user"))) {
            // 序列化 被序列化的对象必须实现序列化接口
            User user = new User("小明","12");
            objectOutputStream.writeObject(user);
        } catch (Exception e) {

        }*/

        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("D:/test.txt"))) {
            //反序列化
            User user = (User)objectInputStream.readObject();
            System.out.println(user);
        }catch (Exception e){

        }
    }

}
