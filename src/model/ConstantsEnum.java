package model;

public enum ConstantsEnum implements Constants {

	enum_EPSILON(EPSILON, "epsilon"),
	enum_DOLLAR(DOLLAR,"dólar"),
	enum_palavra_reservada(t_palavra_reservada,"palavra reservada inválida"),
	enum_identificador_int(t_identificador_int,"identificador"),
	enum_identificador_float(t_identificador_float,"identificador"),
	enum_identificador_string(t_identificador_string,"identificador"),
	enum_identificador_bool(t_identificador_bool,"identificador"),
	enum_constante_int(t_constante_int,"constante int"),
	enum_constante_float(t_constante_float,"constante float"),
	enum_constante_string(t_constante_string,"constante string"),
	enum_and (t_and ,"palavra reservada"),
	enum_endIf (t_endIf ,"palavra reservada"),
	enum_endWhile (t_endWhile ,"palavra reservada"),
	enum_false (t_false ,"palavra reservada"),
	enum_finish (t_finish ,"palavra reservada"),
	enum_if (t_if ,"palavra reservada"),
	enum_in (t_in ,"palavra reservada"),
	enum_isFalseDo (t_isFalseDo ,"palavra reservada"),
	enum_isTrueDo (t_isTrueDo ,"palavra reservada"),
	enum_newLine (t_newLine ,"palavra reservada"),
	enum_not (t_not ,"palavra reservada"),
	enum_or (t_or ,"palavra reservada"),
	enum_out (t_out ,"palavra reservada"),
	enum_space (t_space ,"palavra reservada"),
	enum_start (t_start ,"palavra reservada"),
	enum_tab (t_tab ,"palavra reservada"),
	enum_true (t_true ,"palavra reservada"),
	enum_while (t_while ,"palavra reservada"),
	enum_se_ac ( t_se_ac ,"símbolo especial"),
	enum_se_fc (t_se_fc ,"símbolo especial"),
	enum_se_ap (t_se_ap ,"símbolo especial"),
	enum_se_fp (t_se_fp ,"símbolo especial"),
	enum_se_ig (t_se_ig ,"símbolo especial"),
	enum_se_dif (t_se_dif ,"símbolo especial"),
	enum_se_men (t_se_men ,"símbolo especial"),
	enum_se_mai (t_se_mai ,"símbolo especial"),
	enum_se_mais (t_se_mais ,"símbolo especial"),
	enum_se_menos (t_se_menos ,"símbolo especial"),
	enum_se_mult (t_se_mult ,"símbolo especial"),
	enum_se_divis (t_se_divis ,"símbolo especial"),
	enum_se_virg (t_se_virg ,"símbolo especial"),
	enum_se_pv (t_se_pv ,"símbolo especial"),
	enum_se_dp (t_se_dp ,"símbolo especial"),
	enum_se_atr (t_se_atr ,"símbolo especial"),
	none (-1 ,"token não identificado");
	
	private int identificador;
    private String descricao;

    ConstantsEnum(int identificador, String descricao) {
    	this.identificador = identificador;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static String GetValue(int id)
    {
    	ConstantsEnum[] constantsEnums = ConstantsEnum.values();
        for(int i = 0; i < constantsEnums.length; i++)
        {
            if(constantsEnums[i].identificador == id)
                return constantsEnums[i].descricao;
        }
        return ConstantsEnum.none.descricao;
    }
}