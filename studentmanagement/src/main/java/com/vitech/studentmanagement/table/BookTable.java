package com.vitech.studentmanagement.table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.ButtonEditor;
import com.vitech.studentmanagement.factory.CustomTextField;
import com.vitech.studentmanagement.factory.IconRenderer;
import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.BookList;
import com.vitech.studentmanagement.service.BookService;
import com.vitech.studentmanagement.service.Impl.BookServiceImpl;
import com.vitech.studentmanagement.view.employee.AddEmployeeView;
import com.vitech.studentmanagement.view.employee.EditEmployeeView;

public class BookTable implements ActionListener {

	private JPanel panel;

	private CustomTextField txtSearch;
	private JTextField txtPage;

	private JComboBox<String> cbFilter;

	private JButton btnRefresh;
	private JButton btnAddBook;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;

	private JTable tbBook;

	private JPopupMenu popupMenu;

	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miDeleteAll;

	private BookService bookService;

	private int currentPage = 1;
	private int totalPage = 1;

	public BookTable() {
		initialize();
	}

	private void initialize() {
		createPanel();
		createBookService();
		createTxtSearch();
		createTxtPage();
		createCbFilter();
		createBtnAddBook();
		createBtnFirst();
		createBtnLast();
		createBtnNext();
		createBtnPrevious();
		createBtnRefresh();
		createMiDelete();
		createMiDeleteAll();
		createMiEdit();
		createPopupMenu();
		createTbBook();
	}

	public JPanel createUI() {

		GridLayout glTop = new GridLayout(1, 2);
		JPanel pTop = new JPanel(glTop);

		GridBagLayout gblLeft = new GridBagLayout();
		JPanel pLeft = new JPanel(gblLeft);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridy = 0;
		gbc.gridx = 0;

		pLeft.add(getTxtSearch(), gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.weightx = 0;
		pLeft.add(getCbFilter(), gbc);
		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.weightx = 0;
		pLeft.add(getBtnRefresh());
		pTop.add(pLeft);

		FlowLayout flRight = new FlowLayout(FlowLayout.RIGHT);
		JPanel pRight = new JPanel(flRight);
		pRight.add(getBtnAddBook());
		pTop.add(pRight);

		JScrollPane scrollPane = new JScrollPane(getTbBook());

		FlowLayout flBottom = new FlowLayout(FlowLayout.LEFT);
		JPanel pBottom = new JPanel(flBottom);
		pBottom.add(getBtnFirst());
		pBottom.add(getBtnPrevious());
		pBottom.add(getTxtPage());
		pBottom.add(getBtnNext());
		pBottom.add(getBtnLast());

		getPanel().add(pTop, BorderLayout.NORTH);
		getPanel().add(scrollPane, BorderLayout.CENTER);
		getPanel().add(pBottom, BorderLayout.SOUTH);
		return getPanel();
	}

	public void createTableModel(DefaultTableModel tableModel) {
		tableModel.setRowCount(0);
		getTxtPage().setText("20");
		for (int i=	1; i< 10 ; i++) {
			String[] rowData = new String[9];
			rowData[0] = String.valueOf(i);
			rowData[1] = "BK00"+i;
			rowData[2] = "/book/book_1_icon.png";
			rowData[3] = "Java Programming";
			rowData[4] = "Nhut Nguyen";
			rowData[5] = "Giao Duc";
			rowData[6] = "SGK";
			rowData[7] = "20";
			rowData[8] = "Action";
			tableModel.addRow(rowData);
		}
		/*BookList bookList = getBookService().getAll(currentPage);
		this.totalPage = bookList.getTotalPage();
		String page = String.valueOf(currentPage) + "/"+ String.valueOf(this.totalPage);
		getTxtPage().setText(page);
		int n=0;
		for (Book book : bookList.getBooks()) {
			n++;
			String[] rowData = new String[9];
			rowData[0] = String.valueOf(n);
			rowData[1] = book.getCode();
			rowData[2] = book.getImage();
			rowData[3] = book.getTitle();
			rowData[4] = book.getAuthor();
			rowData[5] = book.getPublisher();
			rowData[6] = book.getKind();
			rowData[7] = String.valueOf(book.getAmount());
			rowData[8] = "Action";
			tableModel.addRow(rowData);
		}*/
	}

	public void createTbBook() {
		ImageIcon iconDelete = new ImageIcon(getClass().getResource(
				"/app/btn_delete_icon.png"));
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("No");
		tableModel.addColumn("Code");
		tableModel.addColumn("Image");
		tableModel.addColumn("Title");
		tableModel.addColumn("Author");
		tableModel.addColumn("Publisher");
		tableModel.addColumn("Kind");
		tableModel.addColumn("Amount");
		tableModel.addColumn("Action");

		createTableModel(tableModel);
		
		this.tbBook = new JTable(tableModel);
		this.tbBook.setRowHeight(30);
		this.tbBook.getColumn("Image").setCellRenderer(new IconRenderer(null));
		this.tbBook.getColumn("Action").setCellRenderer(
				new IconRenderer(iconDelete));
		// this.tbBook.getColumn("Action").setCellRenderer(new
		// ButtonRenderer());
		this.tbBook.getColumn("Action").setCellEditor(
				new ButtonEditor(new JCheckBox()));

		this.tbBook.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.tbBook.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.tbBook.getColumnModel().getColumn(2).setPreferredWidth(30);
		this.tbBook.getColumnModel().getColumn(3).setPreferredWidth(400);
		this.tbBook.getColumnModel().getColumn(4).setPreferredWidth(90);
		this.tbBook.getColumnModel().getColumn(6).setPreferredWidth(50);
		this.tbBook.getColumnModel().getColumn(7).setPreferredWidth(10);
		this.tbBook.getColumnModel().getColumn(8).setPreferredWidth(10);
		this.tbBook.getColumnModel().getColumn(8).setPreferredWidth(30);
		this.tbBook.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.tbBook.setComponentPopupMenu(getPopupMenu());
		this.tbBook.addMouseListener(new TableMouseListener(this.tbBook));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnNext()) {
			if(this.currentPage < this.totalPage ){
				this.currentPage++;
				DefaultTableModel tbModel = (DefaultTableModel) this.getTbBook().getModel();
				createTableModel(tbModel);
			}else{
				JOptionPane.showMessageDialog(this.tbBook,"Sorry this is the last page");
			}
		}
		if (e.getSource() == getBtnPrevious()) {
			if(this.currentPage > 1 ){
				this.currentPage--;
				DefaultTableModel tbModel = (DefaultTableModel) this.getTbBook().getModel();
				createTableModel(tbModel);
			}else{
				JOptionPane.showMessageDialog(this.tbBook,"Sorry this is the first page");
			}
		}
		if (e.getSource() == getBtnFirst() || e.getSource() == getBtnRefresh()) {
			this.currentPage = 1;
			DefaultTableModel tbModel = (DefaultTableModel) this.getTbBook().getModel();
			createTableModel(tbModel);
		}
		if (e.getSource() == getBtnLast()) {
			this.currentPage=this.totalPage;
			DefaultTableModel tbModel = (DefaultTableModel) this.getTbBook().getModel();
			createTableModel(tbModel);
		}
		if(e.getSource() == getBtnAddBook()){
			AddEmployeeView addBookView = new AddEmployeeView();
			addBookView.show();
		}
		if(e.getSource() == getMiEdit()){
			int row = this.tbBook.getSelectedRow();
			String code = this.tbBook.getValueAt(row, 1).toString();
			EditEmployeeView editBookView = new EditEmployeeView(code);
			editBookView.show();
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void createPanel() {
		this.panel = new JPanel(new BorderLayout());
		this.panel.setBorder(BorderFactory
				.createTitledBorder("Student Management"));
	}

	public CustomTextField getTxtSearch() {
		return txtSearch;
	}

	public void createTxtSearch() {
		this.txtSearch = new CustomTextField(20);
		this.txtSearch.setPlaceholder("Text for searching");
	}

	public JTextField getTxtPage() {
		return txtPage;
	}

	public void createTxtPage() {
		this.txtPage = new JTextField();
	}

	public JComboBox<String> getCbFilter() {
		return cbFilter;
	}

	public void createCbFilter() {
		final DefaultComboBoxModel<String> filter = new DefaultComboBoxModel<String>();
		filter.addElement("Name");
		filter.addElement("Code");
		filter.addElement("Phone");
		filter.addElement("Identity");
		this.cbFilter = new JComboBox<String>(filter);
		this.cbFilter.setSelectedIndex(0);
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void createBtnRefresh() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"/app/btn_refresh_icon.png"));
		this.btnRefresh = new JButton(icon);
		this.btnRefresh.addActionListener(this);
	}

	public JButton getBtnAddBook() {
		return btnAddBook;
	}

	public void createBtnAddBook() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"/app/btn_add_icon.png"));
		this.btnAddBook = new JButton("Add Student", icon);
		this.btnAddBook.addActionListener(this);
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public void createBtnFirst() {
		this.btnFirst = new JButton("<<");
		this.btnFirst.addActionListener(this);
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	public void createBtnPrevious() {
		this.btnPrevious = new JButton("<");
		this.btnPrevious.addActionListener(this);
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void createBtnNext() {
		this.btnNext = new JButton(">");
		this.btnNext.addActionListener(this);
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public void createBtnLast() {
		this.btnLast = new JButton(">>");
		this.btnLast.addActionListener(this);
	}

	public JTable getTbBook() {
		return tbBook;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void createPopupMenu() {
		this.popupMenu = new JPopupMenu();
		getPopupMenu().add(getMiEdit());
		getPopupMenu().add(getMiDelete());
		getPopupMenu().add(getMiDeleteAll());
	}

	public JMenuItem getMiDelete() {
		return miDelete;
	}

	public void createMiDelete() {
		this.miDelete = new JMenuItem("Delete");
	}

	public JMenuItem getMiEdit() {
		return miEdit;
	}

	public void createMiEdit() {
		this.miEdit = new JMenuItem("Edit");
		this.miEdit.addActionListener(this);
	}

	public JMenuItem getMiDeleteAll() {
		return miDeleteAll;
	}

	public void createMiDeleteAll() {
		this.miDeleteAll = new JMenuItem("Delete All");
	}

	public BookService getBookService() {
		return bookService;
	}

	public void createBookService() {
		this.bookService = new BookServiceImpl();
	}
}
