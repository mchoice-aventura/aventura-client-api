
using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;


public partial class _Default : System.Web.UI.Page
{
    private MtMessageSender mtMessageSender;
    protected void Page_Load(object sender, EventArgs e)
    {
        string address = txtAddress.Text;
        string message = txtMessage.Text;
        mtMessageSender = new MtMessageSender(address, message);
    }
    protected void Button1_Click1(object sender, EventArgs e)
    {
        try
        {
            string response = mtMessageSender.sendMessage();
            Console.WriteLine(response);
            lblStatus.Text = response;
            lblStatus.Visible = true;
        }
        catch (Exception ex)
        {
            Console.WriteLine("Exception: " + ex);
        }
    } 
}
