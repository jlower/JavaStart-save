package com.learn.www.exercise.javaweb.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/com/learn/www/exercise/javaweb/xml/books.xml");

        System.out.println(document);
    }

    @Test
    public void test2() throws DocumentException {
        //1读取books.xml文件
        SAXReader reader = new SAXReader();
        //在Junit测试中，相对路径是从模块名开始算
        Document document = reader.read("src/com/learn/www/exercise/javaweb/xml/books.xml");
        //2通过Document对象获取根元紊
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);
        //3通过根元素获取book标签对象
        // element()和elements()都是通过标签名查找子元紊
        List<Element> books = rootElement.elements("book");
        //4遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            // asXML()把标签对象。转换为标签字符串
            Element nameElement = book.element("name");
            // getText();可以获取标签中的文本内容
            String nameText = nameElement.getText();
            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");
//            System.out.println("snValue = " + snValue);
            System.out.println(new Book(snValue, nameText, new BigDecimal(priceText), authorText));
//            System.out.println("authorText = " + authorText);



        }
    }

}
