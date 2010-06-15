<%@ Page Language="C#" AutoEventWireup="true" Debug="true" CodeFile="Default.aspx.cs"
    Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Table ID="Table1" runat="server" Height="244px" Width="473px">
                <asp:TableRow runat="server">
                    <asp:TableCell runat="server">
                        <asp:Label ID="lblVersion" runat="server" Text="Version"></asp:Label></asp:TableCell>
                    <asp:TableCell runat="server">
                        <asp:TextBox ID="txtVersion" runat="server" ReadOnly="True">1.0</asp:TextBox></asp:TableCell>
                </asp:TableRow>
                <asp:TableRow runat="server">
                    <asp:TableCell ID="TableCell1" runat="server">
                        <asp:Label ID="lblAddress" runat="server" Text="Address"></asp:Label></asp:TableCell>
                    <asp:TableCell ID="TableCell2" runat="server">
                        <asp:TextBox ID="txtAddress" runat="server"></asp:TextBox></asp:TableCell>
                </asp:TableRow>
                <asp:TableRow runat="server">
                    <asp:TableCell ID="TableCell3" runat="server">
                        <asp:Label ID="lblMessage" runat="server" Text="Message"></asp:Label></asp:TableCell>
                    <asp:TableCell ID="TableCell4" runat="server">
                        <asp:TextBox ID="txtMessage" runat="server"></asp:TextBox></asp:TableCell>
                </asp:TableRow>
                <asp:TableRow ID="TableRow1" runat="server">
                    <asp:TableCell ID="TableCell7" runat="server">
                        <asp:Label ID="Label5" runat="server" Text="Label"></asp:Label></asp:TableCell>
                    <asp:TableCell ID="TableCell8" runat="server">
                        <asp:Button ID="buttonSend" runat="server" Text="SEND" OnClick="Button1_Click1" /></asp:TableCell>
                </asp:TableRow>
            </asp:Table>
        </div>
        <hr />
        <asp:Table ID="Table2" runat="server" Height="156px" Width="471px">
            <asp:TableRow runat="server">
                <asp:TableCell runat="server">
                    <asp:Label ID="Label1" runat="server" Text="Response: "></asp:Label></asp:TableCell>
                <asp:TableCell runat="server">
                    <asp:Label ID="lblStatus" runat="server" Text="Label" Visible="false"></asp:Label></asp:TableCell>
            </asp:TableRow>
        </asp:Table>
        &nbsp;
    </form>
</body>
</html>
