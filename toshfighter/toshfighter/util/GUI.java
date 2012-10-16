package toshfighter.util;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;

import org.powerbot.game.api.util.Timer;

import toshfighter.util.Data;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField monsterId;
	private JTextField customId;
	private JButton start;
	private JButton viewSource;
	private JComboBox<String> foodType;
	private JLabel labelCustom;
	private JSlider hpSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);

		JLabel labelToshFighter = new JLabel("Tosh Fighter");
		labelToshFighter.setFont(new Font("Verdana", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																labelToshFighter)
														.addComponent(
																tabbedPane,
																GroupLayout.PREFERRED_SIZE,
																364,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(76, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(labelToshFighter)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								229, Short.MAX_VALUE)));

		JPanel mainTab = new JPanel();
		tabbedPane.addTab("Main", null, mainTab, null);

		JLabel labelMain = new JLabel("Main");
		labelMain.setFont(new Font("Verdana", Font.BOLD, 13));

		JLabel labelId = new JLabel("Monster ID");
		labelId.setFont(new Font("Verdana", Font.PLAIN, 11));

		monsterId = new JTextField();
		monsterId.setColumns(10);

		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String foodChosen = foodType.getSelectedItem().toString();
				
				Data.monsterId = Integer.parseInt(monsterId.getText());
				Data.eatAt = hpSlider.getValue();
				
				if(foodChosen.equals("Tuna")) {
					Data.foodId = 361;
				}
				if(foodChosen.equals("Lobster")) {
					Data.foodId = 379;
				}
				if(foodChosen.equals("Swordfish")) {
					Data.foodId = 373;
				}
				if(foodChosen.equals("Monkfish")) {
					Data.foodId = 7946;
				}
				if(foodChosen.equals("Shark")) {
					Data.foodId = 385;
				}
				if(foodChosen.equals("Custom")) {
					Data.foodId = Integer.parseInt(customId.getText());
				}
				
				Data.initialized = true;
				Data.timer = new Timer(0);
				dispose();
			}
		});

		viewSource = new JButton("View Source");
		viewSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "www.google.com";
				URI uri = null;

				Desktop dt = Desktop.getDesktop();
				try {
					uri = new URI(url);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				if (uri != null) {
					try {
						dt.browse(uri.resolve(uri));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		JLabel label1 = new JLabel("This script was made for");
		label1.setFont(new Font("Verdana", Font.PLAIN, 11));

		JLabel label2 = new JLabel("Learning purposes and can be");
		label2.setFont(new Font("Verdana", Font.PLAIN, 11));

		JLabel label3 = new JLabel("found on GitHub.");
		label3.setFont(new Font("Verdana", Font.PLAIN, 11));
		GroupLayout gl_mainTab = new GroupLayout(mainTab);
		gl_mainTab
				.setHorizontalGroup(gl_mainTab
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_mainTab
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_mainTab
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_mainTab
																		.createSequentialGroup()
																		.addComponent(
																				labelMain)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				242,
																				Short.MAX_VALUE)
																		.addComponent(
																				labelId))
														.addGroup(
																Alignment.TRAILING,
																gl_mainTab
																		.createSequentialGroup()
																		.addComponent(
																				viewSource)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				155,
																				Short.MAX_VALUE)
																		.addComponent(
																				start,
																				GroupLayout.PREFERRED_SIZE,
																				93,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																monsterId,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label1)
														.addComponent(label2)
														.addComponent(label3))
										.addContainerGap()));
		gl_mainTab.setVerticalGroup(gl_mainTab.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_mainTab
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_mainTab
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(labelMain)
												.addComponent(labelId))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(monsterId,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(label1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label3)
								.addPreferredGap(ComponentPlacement.RELATED,
										60, Short.MAX_VALUE)
								.addGroup(
										gl_mainTab
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(start)
												.addComponent(viewSource))
								.addContainerGap()));
		mainTab.setLayout(gl_mainTab);

		JPanel eatTab = new JPanel();
		tabbedPane.addTab("Eating", null, eatTab, null);

		JLabel labelEating = new JLabel("Eating");
		labelEating.setFont(new Font("Verdana", Font.BOLD, 13));

		JLabel labelSelect = new JLabel("Select your food type");
		labelSelect.setFont(new Font("Verdana", Font.PLAIN, 11));

		foodType = new JComboBox<String>();
		foodType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosen = foodType.getSelectedItem().toString();

				labelCustom.setEnabled(chosen.equals("Custom"));
				customId.setEnabled(chosen.equals("Custom"));
			}
		});
		foodType.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Tuna", "Lobster", "Swordfish", "Monkfish", "Shark", "Custom" }));

		labelCustom = new JLabel("Custom Id");
		labelCustom.setEnabled(false);
		labelCustom.setFont(new Font("Verdana", Font.PLAIN, 11));

		customId = new JTextField();
		customId.setEnabled(false);
		customId.setColumns(10);

		hpSlider = new JSlider();
		hpSlider.setMinimum(40);
		hpSlider.setMaximum(80);
		hpSlider.setMajorTickSpacing(10);
		hpSlider.setMinorTickSpacing(10);
		hpSlider.setValue(60);
		hpSlider.setPaintLabels(true);
		hpSlider.setSnapToTicks(true);
		hpSlider.setPaintTicks(true);

		JLabel labelEatPercent = new JLabel("Percent health to eat at");
		labelEatPercent.setFont(new Font("Verdana", Font.PLAIN, 11));
		GroupLayout gl_eatTab = new GroupLayout(eatTab);
		gl_eatTab
				.setHorizontalGroup(gl_eatTab
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_eatTab
										.createSequentialGroup()
										.addGroup(
												gl_eatTab
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_eatTab
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_eatTab
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								Alignment.TRAILING,
																								gl_eatTab
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												labelEating)
																										.addGroup(
																												gl_eatTab
																														.createSequentialGroup()
																														.addComponent(
																																labelSelect)
																														.addGap(156)
																														.addComponent(
																																labelCustom)))
																						.addGroup(
																								gl_eatTab
																										.createSequentialGroup()
																										.addComponent(
																												foodType,
																												GroupLayout.PREFERRED_SIZE,
																												88,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												165,
																												Short.MAX_VALUE)
																										.addComponent(
																												customId,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								Alignment.TRAILING,
																								gl_eatTab
																										.createSequentialGroup()
																										.addComponent(
																												hpSlider,
																												GroupLayout.PREFERRED_SIZE,
																												289,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(28))))
														.addGroup(
																gl_eatTab
																		.createSequentialGroup()
																		.addGap(106)
																		.addComponent(
																				labelEatPercent)))
										.addContainerGap()));
		gl_eatTab
				.setVerticalGroup(gl_eatTab
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_eatTab
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(labelEating)
										.addGap(34)
										.addGroup(
												gl_eatTab
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																labelSelect)
														.addComponent(
																labelCustom))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_eatTab
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																foodType,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																customId,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 53,
												Short.MAX_VALUE)
										.addComponent(labelEatPercent)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(hpSlider,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		eatTab.setLayout(gl_eatTab);
		contentPane.setLayout(gl_contentPane);
	}
}
