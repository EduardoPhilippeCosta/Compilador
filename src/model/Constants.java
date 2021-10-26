package model;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_palavra_reservada = 2;
    int t_identificador_int = 3;
    int t_identificador_float = 4;
    int t_identificador_string = 5;
    int t_identificador_bool = 6;
    int t_constante_int = 7;
    int t_constante_float = 8;
    int t_constante_string = 9;
    int t_and = 10;
    int t_endIf = 11;
    int t_endWhile = 12;
    int t_false = 13;
    int t_finish = 14;
    int t_if = 15;
    int t_in = 16;
    int t_isFalseDo = 17;
    int t_isTrueDo = 18;
    int t_newLine = 19;
    int t_not = 20;
    int t_or = 21;
    int t_out = 22;
    int t_space = 23;
    int t_start = 24;
    int t_tab = 25;
    int t_true = 26;
    int t_while = 27;
    int t_se_ac = 28;
    int t_se_fc = 29;
    int t_se_ap = 30;
    int t_se_fp = 31;
    int t_se_ig = 32;
    int t_se_dif = 33;
    int t_se_men = 34;
    int t_se_mai = 35;
    int t_se_mais = 36;
    int t_se_menos = 37;
    int t_se_mult = 38;
    int t_se_divis = 39;
    int t_se_virg = 40;
    int t_se_pv = 41;
    int t_se_dp = 42;
    int t_se_atr = 43;

}
