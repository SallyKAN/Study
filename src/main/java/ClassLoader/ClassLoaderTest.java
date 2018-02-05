package ClassLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderTest {
    public static void main(String args[]) {
        JFrame frame = new ClassLoaderFrame();
        frame.setTitle("ClassLoaderTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class ClassLoaderFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;
    private JTextField keyField=new JTextField("3",4);
    private JTextField nameField=new JTextField("Calculator",30);
    public ClassLoaderFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"),new GridBagConstraints(0,0).setAnchor(GridBagConstraints.EAST));
        add(nameField,new GridBagConstraints(1,1).setWeight(100,0).setAnchor(GridBagConstraints.WEST));
        add(new JLabel("key"),new GridBagConstraints(0,1).setAnchor(GridBagConstraints.EAST));
        add(keyField,new GridBagConstraints(100,0).setAnchor(GridBagConstraints.WEST));
        JButton button = new JButton("Load");
        add(button,new GridBagConstraints(0,2,2,1));
        button.addActionListener(event -> runClass(nameField.getText(),keyField.getText()));
    }
    public void runClass(String name, String key){
        try{
            ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
            Class<?> c = loader.loadClass(name);
            Method m = c.getMethod("main",String[].class);
            m.invoke(null,(Object) new String[] {});
        }catch (Throwable e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

    }
}

    class CryptoClassLoader extends ClassLoader {
        private int key;
        public CryptoClassLoader(int key){
            this.key = key;
        }
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] classBytes = null;
                classBytes = loadClassBytes(name);
                Class<?> c = defineClass(name, classBytes, 0, classBytes.length);
                if (c == null) throw new ClassNotFoundException(name);
                return c;
            }catch (IOException e)
            {
                throw new ClassNotFoundException(name);
            }
        }
        private byte[] loadClassBytes(String name) throws IOException
        {
            String cname = name.replace(".","/")+".caser";
            byte[] bytes = Files.readAllBytes(Paths.get(cname));
            for(int i = 0;i<bytes.length;i++)
                bytes[i] = (byte) (bytes[i] - key);
            return bytes;
        }
    }


