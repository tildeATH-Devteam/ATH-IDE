package com.ziddia.ath;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

@SuppressWarnings("deprecation")
public class Viewer extends JFrame implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = -7147185343165348543L;
	TextArea textArea = new TextArea();
	final Highlighter hilit = new DefaultHighlighter();
	final Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);

	public static final void main(String[] args)
	{
		new Viewer().show();
	}
	
	public Viewer()
	{
		super("~ATHFORASSHOLES");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(800, 600));
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Courier", Font.BOLD, 12));
		textArea.addKeyListener(this);
		add("Center", textArea);
		Menu menu = new Menu("File");
        menu.add(makeMenuItem("Open"));
        menu.add(makeMenuItem("Save"));
        menu.add(makeMenuItem("Build"));
        menu.add(makeMenuItem("Quit"));
        Menu menu1 = new Menu("Generate");
        menu1.add(makeMenuItem("Default"));
        menu1.add(makeMenuItem("Authored"));
        menu1.add(makeMenuItem("Basics"));
        menu1.add(makeMenuItem("Full"));
        Menu menu2 = new Menu("Switch");
        menu2.add(makeMenuItem("~ATH"));
        menu2.add(makeMenuItem("^CAKE"));
        //menu2.add(makeMenuItem("&VIL"));
        menu2.add(makeMenuItem("DIS*"));
        Menu menu3 = new Menu("Color");
        menu3.add(makeMenuItem("Red"));
        menu3.add(makeMenuItem("Blue"));
        menu3.add(makeMenuItem("Green"));
        menu3.add(makeMenuItem("Yellow"));
        Menu menu4 = new Menu("Packages");
        Menu menu5 = new Menu("Positions");
        menu5.add(makeMenuItem("Universe"));
        menu5.add(makeMenuItem("Dimension"));
        menu5.add(makeMenuItem("World"));
        menu5.add(makeMenuItem("Session"));
        menu5.add(makeMenuItem("User"));
        menu5.add(makeMenuItem("Location"));
        Menu menu6 = new Menu("Objects");
        menu6.add(makeMenuItem("Object"));
        menu6.add(makeMenuItem("Solid"));
        menu6.add(makeMenuItem("Liquid"));
        menu6.add(makeMenuItem("Gas"));
        menu6.add(makeMenuItem("Plasma"));
        menu4.add(menu5);
        menu4.add(menu6);
        Menu menu7 = new Menu("Declarations");
        Menu menu8 = new Menu("Positions");
        menu8.add(makeMenuItem("Open Universe"));
        menu8.add(makeMenuItem("Open Dimension"));
        menu8.add(makeMenuItem("Open World"));
        menu8.add(makeMenuItem("Open Session"));
        menu8.add(makeMenuItem("Open User"));
        menu8.add(makeMenuItem("Open Location"));
        Menu menu9 = new Menu("Objects");
        menu9.add(makeMenuItem("Open Object"));
        menu9.add(makeMenuItem("Open Solid"));
        menu9.add(makeMenuItem("Open Liquid"));
        menu9.add(makeMenuItem("Open Gas"));
        menu9.add(makeMenuItem("Open Plasma"));
        menu7.add(menu8);
        menu7.add(menu9);
        MenuBar menuBar = new MenuBar();
        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu7);
        setMenuBar(menuBar);
        pack();
	}
	
	private MenuItem makeMenuItem(String name)
    {
        MenuItem m = new MenuItem(name);
        m.addActionListener(this);
        return m;
    }
	
	private MenuItem makeMenuItem(String name, char shortcut)
    {
        MenuItem m = new MenuItem(name, new MenuShortcut(shortcut));
        m.addActionListener(this);
        return m;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String command = arg0.getActionCommand();
        if (command.equals("Quit"))
        {
            dispose();
        	System.exit(0);
        }
        else if (command.equals("Open"))
            openFile();
        else if (command.equals("Save"))
            saveFile();
        else if (command.equals("Build"))
        	buildFile();
        else if (command.equals("Default"))
        	textArea.setText("~ATH(NULL)\n{\n\n    //Additional graves...\n\n} EXECUTE(THIS);\nTHIS.DIE();");
        else if (command.equals("Authored"))
        {
        	String s = JOptionPane.showInputDialog("Please input your name.");
        	if(s == null)
        	{
        		return;
        	}
        	textArea.setText("import author " + s + ";\n\n~ATH(NULL)\n{\n\n    //Additional graves...\n\n} EXECUTE(THIS);\nTHIS.DIE();");
        }
        else if (command.equals("Basics"))
        {
        	textArea.setText("import Universe u;\nimport Dimension d;\nimport Session s;\nimport World w;\nimport Data d;\nimport Object o, o1, o2, o3, o4, o5;\n\n~ATH(NULL)\n{\n\n    //Additional graves...\n\n} EXECUTE(THIS);\nTHIS.DIE();");
        }
        else if (command.equals("Full"))
        {
        	String s = JOptionPane.showInputDialog("Please input your name.");
        	if(s == null)
        	{
        		return;
        	}
        	textArea.setText("import author " + s + ";\nimport Universe u;\nimport Dimension d;\nimport Session s;\nimport World w;\nimport Data d;\nimport Object o, o1, o2, o3, o4, o5;\n\n~ATH(NULL)\n{\n\n    //Additional graves...\n\n} EXECUTE(THIS);\nTHIS.DIE();");
        }
        else if (command.equals("~ATH"))
        {
        	textArea.setText("");
        	textArea.setBackground(Color.BLACK);
    		textArea.setForeground(Color.WHITE);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
        else if (command.equals("^CAKE"))
        {
        	textArea.setText("");
        	textArea.setBackground(Color.GREEN);
    		textArea.setForeground(Color.ORANGE);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
        else if (command.equals("&VIL"))
        {
        	textArea.setText("");
        	textArea.setBackground(Color.WHITE);
    		textArea.setForeground(Color.BLACK);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
        else if (command.equals("DIS*"))
        {
        	textArea.setText("");
        	textArea.setBackground(Color.ORANGE);
    		textArea.setForeground(Color.CYAN);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
        else if (command.equals("Red") || command.equals("Blue") || command.equals("Green") || command.equals("Yellow"))
        	JOptionPane.showMessageDialog(textArea, "Colors are currently broken.", "~ATHINFORMER", JOptionPane.WARNING_MESSAGE);
        else if (command.equals("Universe"))
        	textArea.setText("import Universe u;\n" + textArea.getText());
        else if (command.equals("Dimension"))
        	textArea.setText("import Dimension d;\n" + textArea.getText());
        else if (command.equals("World"))
        	textArea.setText("import World w;\n" + textArea.getText());
        else if (command.equals("Session"))
        	textArea.setText("import Session s;\n" + textArea.getText());
        else if (command.equals("User"))
        	textArea.setText("import User u1;\n" + textArea.getText());
        else if (command.equals("Location"))
        	textArea.setText("import Location l;\n" + textArea.getText());
        else if (command.equals("Solid"))
        	textArea.setText("import Solid s1;\n" + textArea.getText());
        else if (command.equals("Liquid"))
        	textArea.setText("import Liquid l1;\n" + textArea.getText());
        else if (command.equals("Gas"))
        	textArea.setText("import Gas g;\n" + textArea.getText());
        else if (command.equals("Plasma"))
        	textArea.setText("import Plasma p;\n" + textArea.getText());
        else if (command.equals("Object"))
        	textArea.setText("import Object o;\n" + textArea.getText());
        else if (command.equals("Open Universe"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/Universe.html");
        else if (command.equals("Open Dimension"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/Dimension.html");
        else if (command.equals("Open World"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/World.html");
        else if (command.equals("Open Session"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/Session.html");
        else if (command.equals("Open User"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/User.html");
        else if (command.equals("Open Location"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/locations/Location.html");
        else if (command.equals("Open Solid"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/objects/Solid.html");
        else if (command.equals("Open Liquid"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/objects/Liquid.html");
        else if (command.equals("Open Gas"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/objects/Gas.html");
        else if (command.equals("Open Plasma"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/objects/Plasma.html");
        else if (command.equals("Open Object"))
        	openUrl("http://zidmc.com/alpha/ath/declarations/objects/Object.html");
        
	}
	
	private void buildFile()
	{
		//TODO: Work on a joke output stream.
		try
        {
            // Show the dialog box to the user.
            FileDialog fd = new FileDialog(this, "Build File", FileDialog.SAVE);
            fd.setDirectory(System.getProperty("user.dir"));
            fd.setFilenameFilter(new OnlyExt("ATH"));
            fd.show();

            //Get the path and file name.
            StringBuffer sbPath = new StringBuffer(fd.getDirectory());
            sbPath.append("\\");
            // Get the file name to create:
            sbPath.append(fd.getFile());
            FileOutputStream fo = new FileOutputStream(sbPath.toString());

            // Parse the data: 
            String strdata = textArea.getText().toLowerCase();
            String s1 = strdata.replaceAll("a", "z");
    		String s2 = s1.replaceAll("b", "y");
    		String s3 = s2.replaceAll("c", "x");
    		String s4 = s3.replaceAll("d", "w");
    		String s5 = s4.replaceAll("e", "v");
    		String s6 = s5.replaceAll("f", "u");
    		String s7 = s6.replaceAll("g", "t");
    		String s8 = s7.replaceAll("h", "s");
    		String s9 = s8.replaceAll("i", "r");
    		String s10 = s9.replaceAll("j", "q");
    		String s11 = s10.replaceAll("k", "p");
    		String s12 = s11.replaceAll("l", "o");
    		String s13 = s12.replaceAll("m", "n");
    		String s14 = s13.replaceAll("n", "m");
    		String s15 = s14.replaceAll("o", "l");
    		String s16 = s15.replaceAll("p", "k");
    		String s17 = s16.replaceAll("q", "j");
    		String s18 = s17.replaceAll("r", "i");
    		String s19 = s18.replaceAll("s", "h");
    		String s20 = s19.replaceAll("t", "g");
    		String s21 = s20.replaceAll("u", "f");
    		String s22 = s21.replaceAll("v", "e");
    		String s23 = s22.replaceAll("w", "d");
    		String s24 = s23.replaceAll("x", "c");
    		String s25 = s24.replaceAll("y", "b");
    		String s26 = s25.replaceAll("z", "a");
            byte[] data = new byte [s26.length() + 1000];
            for (int idx = 0; idx < s26.length(); idx++)
            {
                data[idx] = (byte)s26.charAt(idx);
            }
            // Write the array to the file.
            fo.write(data);
        }
        catch (IOException ex)
        {
            textArea.setText(ex.toString());
        }
	}

	private void openFile()
    {
        //Show the Open File dialog box to the user.
        FileDialog fd = new FileDialog(this, "Open File", FileDialog.LOAD);
        fd.setDirectory(System.getProperty("user.dir"));
        fd.setFilenameFilter(new OnlyExt("~ATH"));
        fd.show();

        //Get the file path.
        StringBuffer sbPath = new StringBuffer(fd.getDirectory());
        sbPath.append("\\");
        String fileName = fd.getFile();

        //Cancel if null:
        if (fileName == null)
        {
            return;
        }
        else sbPath.append(fileName);

        try
        {
            FileInputStream fs = new FileInputStream(sbPath.toString());
            byte[] data = new byte [ sbPath.length() + 1000];
            fs.read(data);
            textArea.setText(new String(data));
        }
        catch (IOException e)
        {
            textArea.setText(e.toString());
        }
    }

    private void saveFile()
    {
        try
        {
            // Show the dialog box to the user.
            FileDialog fd = new FileDialog(this, "Save File", FileDialog.SAVE);
            fd.setDirectory(System.getProperty("user.dir"));
            fd.setFilenameFilter(new OnlyExt("~ATH"));
            fd.show();

            //Get the path and file name.
            StringBuffer sbPath = new StringBuffer(fd.getDirectory());
            sbPath.append("\\");
            // Get the file name to create:
            sbPath.append(fd.getFile());
            FileOutputStream fo = new FileOutputStream(sbPath.toString());

            // Parse the data: 
            String strdata = textArea.getText();
            byte[] data = new byte [strdata.length() + 1000];
            for (int idx = 0; idx < strdata.length(); idx++)
            {
                data[idx] = (byte)strdata.charAt(idx);
            }
            // Write the array to the file.
            fo.write(data);
        }
        catch (IOException ex)
        {
            textArea.setText(ex.toString());
        }
    }

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}
	
	public void openUrl(String arg)
	{
		if(!Desktop.isDesktopSupported()) 
		{
            System.err.println("Desktop is not supported!");
        }
		Desktop desktop = Desktop.getDesktop();
		if(!desktop.isSupported(Desktop.Action.BROWSE)) 
		{
            System.err.println("Desktop doesn't support the browse action!");
        }
        try {
        	URI uri = new URI(arg);
			desktop.browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
