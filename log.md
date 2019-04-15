


# GB2312转换utf-8

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
