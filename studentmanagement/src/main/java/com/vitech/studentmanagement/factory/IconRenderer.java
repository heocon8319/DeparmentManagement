package com.vitech.studentmanagement.factory;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class IconRenderer extends DefaultTableCellRenderer {

	private ImageIcon icon;

	public IconRenderer(ImageIcon icon) {
		this.icon = icon;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel label = new JLabel();

		if (value != null) {
			label.setHorizontalAlignment(JLabel.CENTER);
			if (icon != null) {
				label.setIcon(this.icon);
			}else{
				if(value.toString().length() <= 25){
					ImageIcon iconBook = new ImageIcon(getClass().getResource(value.toString()));
					label.setIcon(iconBook);
				}else{
					ImageIcon iconBook = new ImageIcon(value.toString());
					label.setIcon(iconBook);
				}
			}
		}

		return label;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
