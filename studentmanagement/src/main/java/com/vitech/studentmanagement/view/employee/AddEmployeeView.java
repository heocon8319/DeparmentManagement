package com.vitech.studentmanagement.view.employee;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.io.FilenameUtils;

import com.vitech.studentmanagement.factory.CustomTextField;
import com.vitech.studentmanagement.model.Book;
import com.vitech.studentmanagement.model.KindOfBook;
import com.vitech.studentmanagement.model.Publisher;
import com.vitech.studentmanagement.service.BookService;
import com.vitech.studentmanagement.service.KindOfBookService;
import com.vitech.studentmanagement.service.PublisherService;
import com.vitech.studentmanagement.service.Impl.BookServiceImpl;
import com.vitech.studentmanagement.service.Impl.KindOfBookServiceImpl;
import com.vitech.studentmanagement.service.Impl.PublisherServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.utility.Utilities;
import com.vitech.studentmanagement.view.ParentUI;

@SuppressWarnings("serial")
public class AddEmployeeView extends ParentUI implements ActionListener {

	private JFrame frame;

	private JLabel lbTitle;
	private JLabel lbImage;

	//private JComboBox<Publisher> cbPublisher;
	private JComboBox<String> cbPublisher;
	//private JComboBox<KindOfBook> cbKindOfBook;
	private JComboBox<String> cbKindOfBook;

	private CustomTextField txtCode;
	private CustomTextField txtAmount;
	private CustomTextField txtTitle;
	private CustomTextField txtAuthor;

	private JFileChooser fileChooser;

	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBrowse;

	private JTextField txtFile;

	private PublisherService publisherService;
	private KindOfBookService kindOfBookService;
	private BookService bookService;

	public AddEmployeeView() {
		initialize();
	}

	private void initialize() {
		createFrame();
		createPublisherService();
		createKindOfBookService();
		createBookService();
		createLbTitle();
		createLbImage();
		createBtnAdd();
		createBtnCancel();
		createCbKindOfBook();
		createCbPublisher();
		createTxtAmount();
		createTxtAuthor();
		createTxtCode();
		createTxtTitle();
		createFileChooser();
		createBtnBrowse();
		createTxtFile();
	}

	public void show() {
		FlowLayout flTitle = new FlowLayout(FlowLayout.CENTER);
		JPanel pTitle = new JPanel(flTitle);
		pTitle.add(getLbTitle());

		GridBagLayout gblCenter = new GridBagLayout();
		JPanel pCenter = new JPanel(gblCenter);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 5, 5, 5);
		gbc.weightx = 1;

		gbc.gridy = 0;
		gbc.gridx = 1;
		pCenter.add(getCbPublisher(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		pCenter.add(getCbKindOfBook(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		pCenter.add(getTxtCode(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		pCenter.add(getTxtAmount(), gbc);

		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		pCenter.add(getTxtTitle(), gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		pCenter.add(getTxtAuthor(), gbc);

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridheight = 4;
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		pCenter.add(getLbImage(), gbc);

		GridLayout glBottom = new GridLayout(2, 1);
		JPanel pBottom = new JPanel(glBottom);

		GridBagLayout gblFile = new GridBagLayout();
		JPanel pFile = new JPanel(gblFile);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		pFile.add(getTxtFile(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.weightx = 0;
		gbc.gridwidth = 0;
		pFile.add(getBtnBrowse(), gbc);
		pBottom.add(pFile);

		FlowLayout flButton = new FlowLayout();
		flButton.setAlignment(FlowLayout.RIGHT);
		JPanel pButtons = new JPanel(flButton);
		pButtons.add(getBtnAdd());
		pButtons.add(getBtnCancel());
		pBottom.add(pButtons);

		getFrame().add(pTitle, BorderLayout.NORTH);
		getFrame().add(pCenter, BorderLayout.CENTER);
		getFrame().add(pBottom, BorderLayout.SOUTH);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Add new book");
		frame.setBounds(100, 100, 350, 370);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(Utilities.WINDOW_ICON.getImage());
		centerScreen(getFrame());
	}

	public JLabel getLbTitle() {
		return lbTitle;
	}

	public void createLbTitle() {
		this.lbTitle = new JLabel("ADD NEW BOOK");
	}

	public JLabel getLbImage() {
		return lbImage;
	}

	public void createLbImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.BOOK_ICON));
		this.lbImage = new JLabel(icon);
	}

	public JComboBox<String> getCbPublisher() {
		return cbPublisher;
	}

	public void createCbPublisher() {
		DefaultComboBoxModel<String> pubs = new DefaultComboBoxModel<String>();
		pubs.addElement("Giao Duc");
		pubs.addElement("Tuoi Tre");
		pubs.addElement("NXB Tre");
		pubs.addElement("Ha Noi");
		
		this.cbPublisher = new JComboBox<String>(pubs);
		
		/*final DefaultComboBoxModel<Publisher> pubs = new DefaultComboBoxModel<Publisher>();
		List<Publisher> pulishers = getPublisherService().getAll();
		for (Publisher p : pulishers) {
			pubs.addElement(p);
		}
		this.cbPublisher = new JComboBox<Publisher>(pubs);
		this.cbPublisher.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Publisher) {
					Publisher publisher = (Publisher) value;
					setText(publisher.getName());
				}
				return this;
			}
		});
		this.cbPublisher.addActionListener(this);*/
	}

	public JComboBox<String> getCbKindOfBook() {
		return cbKindOfBook;
	}

	public void createCbKindOfBook() {
		DefaultComboBoxModel<String> kinds = new DefaultComboBoxModel<String>();
		kinds.addElement("Truyen Tranh");
		kinds.addElement("Tieu Thuyet");
		kinds.addElement("Khoa Hoc");
		kinds.addElement("Hai Huoc");
		
		this.cbKindOfBook = new JComboBox<String>(kinds);
		/*final DefaultComboBoxModel<KindOfBook> kinds = new DefaultComboBoxModel<KindOfBook>();
		List<KindOfBook> kindOfBooks = getKindOfBookService().getAll();
		for (KindOfBook p : kindOfBooks) {
			kinds.addElement(p);
		}
		this.cbKindOfBook = new JComboBox<KindOfBook>(kinds);
		this.cbKindOfBook.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof KindOfBook) {
					KindOfBook kindofbook = (KindOfBook) value;
					setText(kindofbook.getName());
				}
				return this;
			}
		});
		this.cbKindOfBook.addActionListener(this);*/
	}

	private int validation() {
		int result = 0;
		if (getTxtCode().getText().isEmpty() == true
				|| getTxtCode().getText().equals("Code")) {
			result = 1;
		} else {
			if (getTxtAmount().getText().isEmpty() == true
					|| getTxtAmount().getText().equals("Amount")) {
				result = 2;
			} else {
				if (getTxtTitle().getText().isEmpty() == true
						|| getTxtTitle().getText().equals("Title")) {
					result = 3;
				} else {
					if (getTxtAuthor().getText().isEmpty() == true
							|| getTxtAuthor().getText().equals("Author")) {
						result = 4;
					}
				}
			}
		}

		return result;
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnBrowse()) {
			int returnVal = getFileChooser().showOpenDialog(AddEmployeeView.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = getFileChooser().getSelectedFile();
				String ext = FilenameUtils.getExtension(file.getName());
				if (ext.equals("png") == false) {
					JOptionPane.showMessageDialog(getFrame(),
							"File is invalid, please select an image file");
				} else {
					getTxtFile().setText(file.getAbsolutePath());
					ImageIcon icon = new ImageIcon(file.getAbsolutePath());
					getLbImage().setIcon(icon);
				}
			}
		}
		if (e.getSource() == getBtnAdd()) {
			int valid = validation();
			switch (valid) {
			case 0:
				Publisher publisher = (Publisher) getCbPublisher().getSelectedItem();
				KindOfBook kindOfBook = (KindOfBook) getCbKindOfBook().getSelectedItem();
				int publisherId = publisher.getId();
				int kindId = kindOfBook.getId();
				int amount = Integer.parseInt(getTxtAmount().getText());
				String code = getTxtCode().getText();
				String title = getTxtTitle().getText();
				String author = getTxtAuthor().getText();
				String avatar = getTxtFile().getText();
				Book book = new Book(code, title, author, amount, publisherId,kindId, avatar);
				int bookId = bookService.add(book);
				if (bookId > 0) {
					closeWindow(getFrame());
				}else{
					JOptionPane.showMessageDialog(getFrame(),
							"There are some error occur, Please try again");
				}
				break;
			case 1:
				JOptionPane.showMessageDialog(getFrame(),
						"Code field is invalid");
				break;
			case 2:
				JOptionPane.showMessageDialog(getFrame(),
						"Amount field is invalid");
				break;
			case 3:
				JOptionPane.showMessageDialog(getFrame(),
						"Title field is invalid");
				break;
			case 4:
				JOptionPane.showMessageDialog(getFrame(),
						"Author field is invalid");
				break;
			default:
				break;
			}
		}
		if (e.getSource() == getBtnCancel()) {
			closeWindow(getFrame());
		}
	}

	public CustomTextField getTxtCode() {
		return txtCode;
	}

	public void createTxtCode() {
		this.txtCode = new CustomTextField(20);
		this.txtCode.setPlaceholder("Code");
	}

	public CustomTextField getTxtAmount() {
		return txtAmount;
	}

	public void createTxtAmount() {
		this.txtAmount = new CustomTextField(20);
		this.txtAmount.setPlaceholder("Amount");
	}

	public CustomTextField getTxtTitle() {
		return txtTitle;
	}

	public void createTxtTitle() {
		this.txtTitle = new CustomTextField(20);
		this.txtTitle.setPlaceholder("Title");
	}

	public CustomTextField getTxtAuthor() {
		return txtAuthor;
	}

	public void createTxtAuthor() {
		this.txtAuthor = new CustomTextField(20);
		this.txtAuthor.setPlaceholder("Author");
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void createBtnAdd() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.ADD_ICON));
		this.btnAdd = new JButton("Add", icon);
		this.btnAdd.addActionListener(this);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void createBtnCancel() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.CLOSE_ICON));
		this.btnCancel = new JButton("Cancel", icon);
		this.btnCancel.addActionListener(this);
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void createFileChooser() {
		this.fileChooser = new JFileChooser();
	}

	public JButton getBtnBrowse() {
		return btnBrowse;
	}

	public void createBtnBrowse() {
		this.btnBrowse = new JButton("Browse");
		this.btnBrowse.addActionListener(this);
	}

	public JTextField getTxtFile() {
		return txtFile;
	}

	public void createTxtFile() {
		this.txtFile = new JTextField();
	}

	public PublisherService getPublisherService() {
		return publisherService;
	}

	public void createPublisherService() {
		this.publisherService = new PublisherServiceImpl();
	}

	public KindOfBookService getKindOfBookService() {
		return kindOfBookService;
	}

	public void createKindOfBookService() {
		this.kindOfBookService = new KindOfBookServiceImpl();
	}

	public BookService getBookService() {
		return bookService;
	}

	public void createBookService() {
		this.bookService = new BookServiceImpl();
	}
}
