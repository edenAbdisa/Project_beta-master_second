namespace Plugin_System
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
            this.label1 = new System.Windows.Forms.Label();
            this.labelz = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.errorDisplay = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(28, 95);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(131, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "Assembly Name :";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // labelz
            // 
            this.labelz.AutoSize = true;
            this.labelz.Location = new System.Drawing.Point(185, 95);
            this.labelz.Name = "labelz";
            this.labelz.Size = new System.Drawing.Size(107, 20);
            this.labelz.TabIndex = 1;
            this.labelz.Text = "Name display ";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(215, 192);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 40);
            this.button1.TabIndex = 2;
            this.button1.Text = "show";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // errorDisplay
            // 
            this.errorDisplay.Enabled = false;
            this.errorDisplay.Location = new System.Drawing.Point(32, 12);
            this.errorDisplay.Name = "errorDisplay";
            this.errorDisplay.ReadOnly = true;
            this.errorDisplay.Size = new System.Drawing.Size(466, 40);
            this.errorDisplay.TabIndex = 3;
            this.errorDisplay.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(510, 244);
            this.Controls.Add(this.errorDisplay);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.labelz);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelz;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.RichTextBox errorDisplay;
    }
}

