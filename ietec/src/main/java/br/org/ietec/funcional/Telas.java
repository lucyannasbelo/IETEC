package br.org.ietec.funcional;

public class Telas {
	
	public static void casoTesteLoginNaoExistente()
	{
		Utils.IsClickableAndClick(Constant.MY_ACCOUNT);
		Utils.IsClickableClearAndFillOut(Constant.USERNAME, "testIetec");
		Utils.IsClickableClearAndFillOut(Constant.PASSWORD, "123456");
		Utils.IsClickableAndClick(Constant.LOGIN);
		Utils.CompareLocatorContainTextWithMsg("Login existe e não deveria existir", Constant.MSGERRO, Constant.MSG_ERRO_LOGIN);
	}

	public static void casoTestePesquisaDeProdutoQueNaoExiste()
	{
		Utils.IsClickableClearAndFillOut(Constant.SEARCH, "ferrari");
		Utils.Enter(Constant.SEARCH);
		Utils.CompareLocatorContainTextWithMsg("Mesmo não tendo retorno, retornou algo", Constant.MSG_NAO_ENCONTRADO_LOCATOR,  Constant.MSG_NAO_ENCONTRADO);
	}
	
	public static void casoTesteAtualizarCarrinho()
	{
		Utils.IsClickableAndClick(Constant.MENU_PRODUCTS);
		Utils.IsClickableAndClick(Constant.COMPRAR);
		Utils.IsClickableAndClick(Constant.CHECKOUT);
		Utils.IsClickableClearAndFillOut(Constant.QUANTIDADE, "2");
		Utils.IsClickableAndClick(Constant.UPDATE_QUANT);
		Utils.CompareLocatorNotContainTextWithMsg("Não atualizou", Constant.VALORUNITARIO, Utils.GetText(Constant.VALORTOTAL));
	}
}
