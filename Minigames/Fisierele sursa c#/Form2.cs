using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace joc_tata
{

    public partial class Form2 : Form
    {
        Image img;
        String txt;
        public Form2()
        {
            Image w;
            InitializeComponent();
            w = joc_tata.Properties.Resources.back;
            w = Resize(w, 1200, 700);
            this.BackgroundImage = w;
            label1.BackColor = System.Drawing.Color.Transparent;
            label2.BackColor = System.Drawing.Color.Transparent;
            label3.BackColor = System.Drawing.Color.Transparent;
            textBox1.BackColor = this.BackColor;
            textBox1.BorderStyle = 0;
            pictureBox1.BackColor = System.Drawing.Color.Transparent;
           
        }
        Image Resize(Image image, int w, int h)
        {
            Bitmap bmp = new Bitmap(w, h);
            Graphics graphic = Graphics.FromImage(bmp);
            graphic.DrawImage(image, 0, 0, w, h);
            graphic.Dispose();
            return bmp;
        }



        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            OpenFileDialog opnfd = new OpenFileDialog();
            opnfd.Filter = "Image Files (*.jpg;*.jpeg;.*.gif;)|*.jpg;*.jpeg;.*.gif";
            if (opnfd.ShowDialog() == DialogResult.OK)
            {
                img = new Bitmap(opnfd.FileName);
                img = Resize(img, 190, 120);
                pictureBox1.Image = img;
            }


        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (img == null && textBox1.TextLength ==0 )
            {
                MessageBox.Show("Ai uitat sa adaugi imaginea si numele prietenului");
            
            }

            else
            {
                if (img == null)
                {
                    MessageBox.Show("Ai uitat sa adaugi imaginea prietenului");
                }
                else
                {
                    if (textBox1.TextLength ==0 )
                    {
                        MessageBox.Show("Ai uitat sa adaugi numele prietenului");

                    }
                    else
                    {


                        this.Hide();
                        txt = textBox1.Text;
                        Form1 f = new Form1(txt, img);

                            f.ShowDialog();
                        

                    }
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form2 f = new Form2();
            f.ShowDialog();

        }
    }
}


