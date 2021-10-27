package model;

public interface ParserConstants
{
    int START_SYMBOL = 44;

    int FIRST_NON_TERMINAL    = 44;
    int FIRST_SEMANTIC_ACTION = 81;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  2,  2,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1,  2,  2, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1 },
        { -1, -1,  3,  3,  3,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5,  4, -1, -1 },
        { -1, -1,  6,  6,  6,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  7,  8,  9, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, 12, -1, -1 },
        { -1, -1, 13, 13, 13, 13, -1, -1, -1, -1, -1, -1, -1, -1, 13, 13, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 15, 15, 15, 15, -1, -1, -1, -1, 14, 14, -1, 14, 15, 15, 14, -1, -1, -1, -1, 15, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 19, 17, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 21, 21, 21, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, 23 },
        { -1, -1, 25, 25, 25, 25, -1, -1, -1, -1, 25, 25, -1, 25, 25, 25, 25, -1, -1, -1, -1, 25, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 28, 28, 28, 28, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 29, 29, 29, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 33, 33, 33, 33, 33, 33, 33, -1, -1, -1, 33, -1, -1, -1, -1, -1, 33, 33, -1, -1, 33, -1, 33, 33, -1, -1, -1, 33, -1, -1, -1, -1, -1, 33, 33, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 42, 42, 42, 42, 42, 42, 42, -1, -1, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, 42, -1, 42, 42, -1, -1, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 43, 43, 43, 43, -1, -1, -1, 44, 43, 43, -1, 43, 43, 43, 43, 43, -1, -1, 45, 43, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1 },
        { -1, -1, 46, 46, 46, 46, 46, 46, 46, -1, -1, -1, 48, -1, -1, -1, -1, -1, 46, 49, -1, -1, 46, -1, 46, 47, -1, -1, -1, 46, -1, -1, -1, -1, -1, 46, 46, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 50, 50, 50, 50, 50, 50, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, 50, -1, -1, -1, 50, -1, 50, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, 50, 50, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 51, 51, 51, 51, -1, -1, -1, 51, 51, 51, -1, 51, 51, 51, 51, 51, -1, -1, 51, 51, -1, -1, -1, -1, 51, -1, 51, -1, 51, 52, 52, 52, 52, -1, -1, -1, -1, 51, -1, 51, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, 54, 55, 56, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 57, 57, 57, 57, 57, 57, 57, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, -1, -1, 57, -1, 57, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, 57, 57, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 58, 58, 58, 58, -1, -1, -1, 58, 58, 58, -1, 58, 58, 58, 58, 58, -1, -1, 58, 58, -1, -1, -1, -1, 58, -1, 58, -1, 58, 58, 58, 58, 58, 59, 60, -1, -1, 58, -1, 58, -1 },
        { -1, -1, 61, 61, 61, 61, 61, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, -1, -1, 61, -1, 61, -1, -1, -1, -1, 61, -1, -1, -1, -1, -1, 61, 61, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 62, 62, 62, 62, -1, -1, -1, 62, 62, 62, -1, 62, 62, 62, 62, 62, -1, -1, 62, 62, -1, -1, -1, -1, 62, -1, 62, -1, 62, 62, 62, 62, 62, 62, 62, 63, 64, 62, -1, 62, -1 },
        { -1, -1, 65, 65, 65, 65, 66, 67, 68, -1, -1, -1, -1, -1, -1, -1, -1, -1, 69, -1, -1, -1, 70, -1, 71, -1, -1, -1, -1, 72, -1, -1, -1, -1, -1, 73, 74, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 75, 75, 75, 75, -1, -1, -1, 75, 75, 75, -1, 75, 75, 75, 75, 75, -1, -1, 75, 75, -1, -1, -1, -1, 75, 76, 75, -1, 75, 75, 75, 75, 75, 75, 75, 75, 75, 75, -1, 75, -1 },
        { -1, -1, 77, 78, 79, 80, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 24, 45, 51, 14 },
        { 42, 46, 41 },
        {  0 },
        { 48, 47 },
        {  0 },
        { 40, 46 },
        { 49, 50 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 28,  7, 29 },
        {  0 },
        { 53, 52 },
        {  0 },
        { 51 },
        { 54 },
        { 57 },
        { 61 },
        { 64 },
        { 66 },
        { 49, 55, 43, 68, 56 },
        { 28, 68, 29 },
        {  0 },
        { 42, 15, 68 },
        {  0 },
        { 16, 30, 58, 59, 31 },
        {  9, 40 },
        {  0 },
        { 49, 55, 60 },
        {  0 },
        { 40, 59 },
        { 22, 30, 62, 31 },
        { 68, 63 },
        {  0 },
        { 40, 62 },
        { 15, 68, 18, 51, 65, 11 },
        { 17, 51 },
        {  0 },
        { 27, 68, 67, 51, 12 },
        { 18 },
        { 17 },
        { 70, 69 },
        {  0 },
        { 10, 70, 69 },
        { 21, 70, 69 },
        { 71 },
        { 26 },
        { 13 },
        { 20, 70 },
        { 74, 72 },
        {  0 },
        { 73, 74 },
        { 32 },
        { 33 },
        { 34 },
        { 35 },
        { 76, 75 },
        {  0 },
        { 36, 76, 75 },
        { 37, 76, 75 },
        { 78, 77 },
        {  0 },
        { 38, 78, 77 },
        { 39, 78, 77 },
        { 80, 79 },
        {  7 },
        {  8 },
        {  9 },
        { 19 },
        { 23 },
        { 25 },
        { 30, 68, 31 },
        { 36, 78 },
        { 37, 78 },
        {  0 },
        { 28, 68, 29 },
        {  3 },
        {  4 },
        {  5 },
        {  6 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "esperado EOF",// Era esperado fim de programa
        "esperado palavra_reservada",//Era esperado palavra_reservada
        "esperado identificador",//Era esperado identificador_int
        "esperado identificador",//Era esperado identificador_float
        "esperado identificador",//Era esperado identificador_string
        "esperado identificador",//Era esperado identificador_bool
        "esperado constante",//esperado constante_int
        "esperado constante",//esperado constante_float
        "esperado constante",//esperado constante_string
        "esperado and",//Era esperado and
        "esperado endIf",//Era esperado endIf
        "esperado endWhile",//Era esperado endWhile
        "esperado false",//Era esperado false
        "esperado finish",//Era esperado finish
        "esperado if",//Era esperado if
        "esperado in",//Era esperado in
        "esperado isFalseDo",//Era esperado isFalseDo
        "esperado isTrueDo",//Era esperado isTrueDo
        "esperado newLine",//Era esperado newLine
        "esperado not",//Era esperado not
        "esperado or",//Era esperado or
        "esperado out",//Era esperado out
        "esperado space",//Era esperado space
        "esperado start",//Era esperado start
        "esperado tab",//Era esperado tab
        "esperado true",//Era esperado true
        "esperado while",//Era esperado while
        "esperado '['",//Era esperado se_ac
        "esperado ']'",//Era esperado se_fc
        "esperado '('",//Era esperado se_ap
        "esperado ')'",//Era esperado se_fp
        "esperado '=='",//Era esperado se_ig
        "esperado '<>'",//Era esperado se_dif
        "esperado '<'",//Era esperado se_men
        "esperado '>'",//Era esperado se_mai
        "esperado '+'",//Era esperado se_mais
        "esperado '-'",//Era esperado se_menos
        "esperado '*'",//Era esperado se_mult
        "esperado '/'",//Era esperado se_divis
        "esperado ','",//Era esperado se_virg
        "esperado ';'",//Era esperado se_pv
        "esperado ':'",//Era esperado se_dp
        "esperado '='",//Era esperado se_atr
        "esperado start",//<programa> inválido
        "esperado identificador if in out while :",//<declaracao_variaveis> inválido
        "esperado , ;",//<lista_identificadores> inválido
        "esperado , ;",//<lista_identificadores1> inválido
        "<identificador> inválido",//
        "<outro_identificador> inválido",//
        "esperado [ , ;",//<colchetes_array> inválido
        "esperado identificador if in out while",//<lista_comandos> inválido
        "esperado identificador if in out while",//<lista_comandos1> inválido
/**/	"",//<comando> inválido
/**/    "",//<comando_atribuicao> inválido
/**/    "",//<expressao_opcional> inválido
/**/    "",//<sufixo> inválido
/**/    "",//<comando_entrada_dados> inválido
/**/    "",//<constante_string_opcional> inválido
        "esperado expressão",//<lista_variaveis> inválido
        "esperado expressão",//<lista_variaveis1> inválido
/**/    "",//<comando_saida_dados> inválido
        "esperado expressão",//<lista_expressoes> inválido
        "esperado expressão",//<lista_expressoes1> inválido
        "esperado ",//<comando_selecao> inválido
        "esperado isFalseDo",//<comando_IsFalseDo_opcional> inválido
/**/    "esperado while",//<comando_repeticao> inválido
        "esperado isTrueDo ou isFalseDo",//<comando_repeticao1> inválido
        "esperado expressão",//<expressao> inválido
        "esperado expressão",//<expressao_> inválido
        "esperado expressão",//<elemento> inválido
        "esperado expressão",//<relacional> inválido
        "esperado expressão",//<relacional_> inválido
        "esperado '==', '<>', '>' ou '>' ",//<operador_relacional> inválido
        "esperado expressão",//<aritmetica> inválido
        "esperado expressão",//<aritmetica_> inválido
        "esperado expressão",//<termo> inválido
        "esperado expressão",//<termo_> inválido
        "esperado expressão",//<fator> inválido
        "esperado expressão",//<fator_> inválido
        "esperado identificador_int ou indentificador_float"//<identificador_fator> inválido
    };
}

