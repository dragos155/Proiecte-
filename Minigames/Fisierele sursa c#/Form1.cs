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

    public partial class Form1 : Form
    { 
     
        int incercari = 10;
        Image bb;
        string aa;
        public Form1(string a,Image b)
        {
            bb = b;
            aa = a;
            Random rnd = new Random();
            int aux1 = rnd.Next(1, 26);
          
            InitializeComponent();
            label_incercari.Text = "Încercări rămase: " + incercari+aux1; //am pus aici aux1 ,pentru a vedea inaintea jocului pozitia "prietenul"
            for (int i = 1; i <= 25; i++)
                
                {

                    Button btn = new Button();           
                    btn.SetBounds(0, 0,190, 120);         
                    btn.Tag = "";                        
                    flowLayoutPanel1.Controls.Add(btn);  
                    if (i == aux1)                
                        btn.Tag = "Tata";             
                    btn.Click += Btn_Click;   
                }                             
        }
     

        private void Btn_Click(object sender, EventArgs e)
        { 
            Button btn = (Button)sender;
            if (incercari > 0)
            { if (btn.Tag.ToString() == "") {
                    btn.Tag = "1";
                    btn.BackColor = Color.Black;
                    incercari--;
                }


                if (btn.Tag.ToString() == "Tata")  
                {
                    
                    bb=Resize(bb,190,120);
                    btn.BackgroundImage =bb;
                    
                    MessageBox.Show("L-ai gasit pe "+aa+" !");
                    this.Hide();
                    Form2 f = new Form2();
                    f.ShowDialog();

                }
                                         
                label_incercari.Text = "Încercări rămase: " + incercari;  
                if (incercari == 0)
                {
                    MessageBox.Show("Mai incearca!");
                    this.Hide();
                    Form2 f = new Form2();
                    f.ShowDialog();
                    
                }
            }
        }

        Image Resize(Image image, int w, int h)
        { Bitmap bmp = new Bitmap(w, h);
            Graphics graphic = Graphics.FromImage(bmp);
            graphic.DrawImage(image, 0, 0, w, h);
            graphic.Dispose();
            return bmp;
        }
    }
}
