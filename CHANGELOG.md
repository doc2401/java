# checksum
$  find  ./*.zip  -type f -exec sha256sum {} \;
ebb1b88cb5c081df540c679d882ab2a62ab720582451f6f29ea8cd961c194154  ./html_zh_CN.zip
9e41b66d1d640e50a23fe4ad68d626465c1f72410c6d2b0011d56564bbf85f7d  ./j2sdk-1_3_1-doc.zip
5d7ef04d1a9fa721f03eca7751f8eaaebd0de2d629ff90dc1a0d5628bc64ba58  ./j2sdk-1_4_2-doc.zip
b343c85f37dfbd96a26b11b8d88f9dd450c4aba0c6607999be37de596a2d709f  ./java_ee_sdk-8.zip
75da39c007718b32bb0021d3490f46180e29596b7740c1efa34da4cef5a4c547  ./javafx-8u201-apidocs.zip
01c164a03ff5046dc06d0d3ea30dd9f0e969eda52bd774ff145c2b1c381fe22b  ./javafx-8u202-apidocs.zip
cb7b1703e9e1ef8adc2506672e5d6396df2d76a4f9f4dda8e4226b4ae52852a8  ./jdk-10.0.2_doc-all.zip
8723e26bf097b4b9375851338270870d3b5ef1a3843f0631597adb9039308083  ./jdk-11.0.2_doc-all.zip
a14eaa08517bf369e7c72a829ff8dbfd42c29167d41fdcd2057cdaccf661c370  ./jdk-12_doc-all.zip
48b98ef0746278da2c6a32649608ec06729529fc4c9ea5d8584aa2b1acf0634e  ./jdk-1_5_0-doc.zip
92739c56e02fa6e7ac8d60a1f59a0ef4a59ac99ab2979d3cdc495bfecf1a50ab  ./jdk-6u30-apidocs.zip
0494bd49bc9cb3cbe3203120ae8b2c8e0aeb1579cb15c0fbd3cd780d19aa200a  ./jdk-7u80-docs-all.zip
9dbfaa290b952b5fb93e43083222995ee8e7773367b002de6c8e2fc72701e2f5  ./jdk-8u201-docs-all.zip
c036b8daf867925cc7eb59dfd2f50a72c66f88128a9c174d98bafeb907e56e74  ./jdk-8u202-docs-all.zip
7736ec58f0bc4abf60ecac092c8cc35e5840e292b775b44949dd6dde3b9516b3  ./jdk-9.0.1_doc-all.zip
66a7e0948f109020bfb5483848e9998b2624043074d7aae974e89e85a6e14d37  ./jdk-9.0.4_doc-all.zip


# download

http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_doc-all.zip
http://download.oracle.com/otn-pub/java/jdk/9.0.4+11/c2514751926b4512b076cc82f959763f/jdk-9.0.4_doc-all.zip

- [Java Development Kit 8 Documentation](https://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html)
- [Java Development Kit 11 Documentation](https://www.oracle.com/technetwork/java/javase/documentation/jdk11-doc-downloads-5097203.html)
- [Java Development Kit 12 Documentation](https://www.oracle.com/technetwork/java/javase/documentation/jdk12-doc-downloads-5296039.html)
- [Java EE 8 SDK Download Page](https://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-7-downloads-1956236.html)

- [jdkxz Japanese Information - OSDN](https://osdn.net/projects/sfnet_jdkxz/)
- [raphaello.univ-fcomte.fr - /FTP/Java/Jdk/](http://raphaello.univ-fcomte.fr/FTP/Java/Jdk/)
- [JAVA帮助文档全系列 JDK1.5 JDK1.6 JDK1.7 官方中英完整版下载 - Leo Chin - 博客园](http://www.cnblogs.com/hnrainll/archive/2011/10/11/2206804.html#commentform)
- [canghailan/oracle-downloader: Oracle JDK Download Scripts （Oracle JDK 下载脚本）](https://github.com/canghailan/oracle-downloader)
- [jdk-7u80-docs-all-CSDN下载](https://download.csdn.net/download/liuyun213/9773539)
- [[gentoo-x86] Diff of /dev-java/java-sdk-docs/Manifest](https://sources.gentoo.org/cgi-bin/viewvc.cgi/gentoo-x86/dev-java/java-sdk-docs/Manifest)




# GB2312转换utf-8

jdk6 中文文档 转换为utf-8


 ```bash
## 查看所有html文件编码
  find .  -type f -name "*.html" -exec bash -c 'echo -n $1" ">> enca.list && enca -L chinese  $1>> enca.list   ' -- {} \;

# 查看 非 GB2312 文件 事先重命名去掉html后缀 转码完后再 加回来
  grep -v GB2312 enca.list

## 打印并且转换文件 部分文件无需转码 可以先
  find .  -type f -name "*.html" -exec bash -c 'echo  $1 && iconv -f "gb2312" -t "UTF-8" $1 > $1.converted && mv $1.converted $1' -- {} \;


## 去掉非 GB2312 文件都后缀名
mv ./api/java/awt/doc-files/AWTThreadIssues.html                    ./api/java/awt/doc-files/AWTThreadIssues.                          
mv ./api/java/awt/doc-files/DesktopProperties.html                  ./api/java/awt/doc-files/DesktopProperties.                        
mv ./api/java/awt/doc-files/FocusSpec.html                          ./api/java/awt/doc-files/FocusSpec.                                
mv ./api/java/awt/doc-files/Modality.html                           ./api/java/awt/doc-files/Modality.                                 
mv ./api/javax/imageio/metadata/doc-files/bmp_metadata.html         ./api/javax/imageio/metadata/doc-files/bmp_metadata.               
mv ./api/javax/imageio/metadata/doc-files/gif_metadata.html         ./api/javax/imageio/metadata/doc-files/gif_metadata.               
mv ./api/javax/imageio/metadata/doc-files/jpeg_metadata.html        ./api/javax/imageio/metadata/doc-files/jpeg_metadata.              
mv ./api/javax/imageio/metadata/doc-files/png_metadata.html         ./api/javax/imageio/metadata/doc-files/png_metadata.               
mv ./api/javax/imageio/metadata/doc-files/standard_metadata.html    ./api/javax/imageio/metadata/doc-files/standard_metadata.          
mv ./api/javax/imageio/metadata/doc-files/wbmp_metadata.html        ./api/javax/imageio/metadata/doc-files/wbmp_metadata.              
mv ./api/javax/swing/plaf/multi/doc-files/multi_tsc.html            ./api/javax/swing/plaf/multi/doc-files/multi_tsc.                  
mv ./api/javax/swing/plaf/synth/doc-files/componentProperties.html  ./api/javax/swing/plaf/synth/doc-files/componentProperties.        
mv ./api/javax/swing/plaf/synth/doc-files/synthFileFormat.html      ./api/javax/swing/plaf/synth/doc-files/synthFileFormat.            
mv ./api/org/omg/CORBA/doc-files/compliance.html                    ./api/org/omg/CORBA/doc-files/compliance.                          
mv ./api/org/omg/CORBA/doc-files/generatedfiles.html                ./api/org/omg/CORBA/doc-files/generatedfiles.     


## 添加回后缀名
mv  ./api/java/awt/doc-files/AWTThreadIssues.                    ./api/java/awt/doc-files/AWTThreadIssues.html                            
mv  ./api/java/awt/doc-files/DesktopProperties.                  ./api/java/awt/doc-files/DesktopProperties.html                          
mv  ./api/java/awt/doc-files/FocusSpec.                          ./api/java/awt/doc-files/FocusSpec.html                                  
mv  ./api/java/awt/doc-files/Modality.                           ./api/java/awt/doc-files/Modality.html                                   
mv  ./api/javax/imageio/metadata/doc-files/bmp_metadata.         ./api/javax/imageio/metadata/doc-files/bmp_metadata.html                 
mv  ./api/javax/imageio/metadata/doc-files/gif_metadata.         ./api/javax/imageio/metadata/doc-files/gif_metadata.html                 
mv  ./api/javax/imageio/metadata/doc-files/jpeg_metadata.        ./api/javax/imageio/metadata/doc-files/jpeg_metadata.html                
mv  ./api/javax/imageio/metadata/doc-files/png_metadata.         ./api/javax/imageio/metadata/doc-files/png_metadata.html                 
mv  ./api/javax/imageio/metadata/doc-files/standard_metadata.    ./api/javax/imageio/metadata/doc-files/standard_metadata.html            
mv  ./api/javax/imageio/metadata/doc-files/wbmp_metadata.        ./api/javax/imageio/metadata/doc-files/wbmp_metadata.html                
mv  ./api/javax/swing/plaf/multi/doc-files/multi_tsc.            ./api/javax/swing/plaf/multi/doc-files/multi_tsc.html                    
mv  ./api/javax/swing/plaf/synth/doc-files/componentProperties.  ./api/javax/swing/plaf/synth/doc-files/componentProperties.html          
mv  ./api/javax/swing/plaf/synth/doc-files/synthFileFormat.      ./api/javax/swing/plaf/synth/doc-files/synthFileFormat.html              
mv  ./api/org/omg/CORBA/doc-files/compliance.                    ./api/org/omg/CORBA/doc-files/compliance.html                            
mv  ./api/org/omg/CORBA/doc-files/generatedfiles.                ./api/org/omg/CORBA/doc-files/generatedfiles.html    
```  
