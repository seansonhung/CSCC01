package com.teqlip.gui.panels;

import javax.swing.*;

public class TEQUploadDialogBox {

	private JPanel panel;
	private String path;
    private JTextField pathField;

	private JFileChooser fileChooser;
	private int rVal;

	public TEQUploadDialogBox(JPanel panel, JTextField pathField) {
		this.panel = panel;
        this.pathField = pathField;
		this.fileChooser = new JFileChooser();
	}

	public void showOpenDialog() {
		this.rVal = this.fileChooser.showOpenDialog(this.panel);
		
		if (rVal == JFileChooser.APPROVE_OPTION) {
			this.path = this.fileChooser.getCurrentDirectory().toString() + "/" + this.fileChooser.getSelectedFile().getName();
            this.pathField.setText(this.path);
		}
	}
}
