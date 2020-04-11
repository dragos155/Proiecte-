namespace joc_tata
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label_incercari = new System.Windows.Forms.Label();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // label_incercari
            // 
            this.label_incercari.AutoSize = true;
            this.label_incercari.Location = new System.Drawing.Point(-1, 794);
            this.label_incercari.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label_incercari.Name = "label_incercari";
            this.label_incercari.Size = new System.Drawing.Size(121, 17);
            this.label_incercari.TabIndex = 1;
            this.label_incercari.Text = "Încercări rămase: ";
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(2, 3);
            this.flowLayoutPanel1.Margin = new System.Windows.Forms.Padding(4);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(1315, 787);
            this.flowLayoutPanel1.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1319, 832);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.label_incercari);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gaseste-ti prietenul !";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label_incercari;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
    }
}
