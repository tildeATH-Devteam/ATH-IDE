package com.ziddia.ath;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        Menu menu3 = new Menu("Color");
        menu3.add(makeMenuItem("Red"));
        menu3.add(makeMenuItem("Blue"));
        menu3.add(makeMenuItem("Green"));
        menu3.add(makeMenuItem("Yellow"));
        MenuBar menuBar = new MenuBar();
        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        setMenuBar(menuBar);
        pack();
	}
	
	private MenuItem makeMenuItem(String name)
    {
        MenuItem m = new MenuItem(name);
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
        	textArea.setBackground(Color.ORANGE);
    		textArea.setForeground(Color.RED);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
        else if (command.equals("&VIL"))
        {
        	textArea.setText("");
        	textArea.setBackground(Color.WHITE);
    		textArea.setForeground(Color.BLACK);
    		textArea.setFont(new Font("Courier", Font.BOLD, 12));
        }
	}
	
	private void buildFile()
	{
		//TODO: Work on a joke output stream.
		try
        {
            // Show the dialog box to the user.
            FileDialog fd = new FileDialog(this, "Build File", FileDialog.SAVE);
            fd.setDirectory(System.getProperty("user.dir"));
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

}
