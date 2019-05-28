using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms; 
using Plugins;
using System.Reflection;

namespace Plugin_System
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog op = new OpenFileDialog();
            if (op.ShowDialog() == DialogResult.OK)
            {
                try { Assembly.LoadFrom(op.FileName); }
                catch(Exception c)
                {
                    errorDisplay.Text = "Couldnt upload the Assembly file check the format";
                }
                foreach (Assembly a in AppDomain.CurrentDomain.GetAssemblies())
                {
                    foreach (Type t in a.GetTypes())
                    {
                        if (t.GetInterface("Plugin") != null)
                        {
                            
                            Plugin p = Activator.CreateInstance(t) as Plugin;
                            if (p==null) {
                                MessageBox.Show("Couldnt create the plugin");
                            }
                            
                            labelz.Text = p.PluginName();                            
                             p.run();
                            
                        }
                    }
                }
           
            }
            
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
