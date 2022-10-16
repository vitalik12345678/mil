package com.data.mil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum RankEnum {
    kursant("kursant"),
    MOLODSHYY_LEYTENANT("molodshyy leytenant"),
    LEYTENANT("leytenant"),
    STARSHYY_LEYTENANT("starshyy leytenant"),
    KAPITAN("kapitan"),
    MAYOR("mayor"),
    PIDPOLKOVNYK("pidpolkovnyk"),
    POLKOVNYK("polkovnyk"),
    BRYHADNYY_HENERAL("bryhadnyy heneral"),
    HENERAL_MAYOR("heneral-mayor"),
    HENERAL_LEYTENAN("heneral-leytenan"),
    HENERAL("heneral"),
    SOLDAT("soldat"),
    STARSHYY_SOLDAT("starshyy soldat"),
    MOLODSHYY_SERZHANT("molodshyy serzhant"),
    SERZHANT("serzhant"),
    STARSHYY_SERZHANT("starshyy serzhant"),
    HOLOVNYY_SERZHANT("holovnyy serzhant"),
    SHTAB_SERZHANT("shtab-serzhant"),
    MAYSTER_SERZHANT("mayster-serzhant"),
    STARSHYY_MAYSTER_SERZHANT("starshyy mayster-serzhant"),
    HOLOVNYY_MAYSTER_SERZHANT("holovnyy mayster-serzhant"),
    KAPITAN_LEYTENANT("kapitan-leytenant"),
    KAPITAN_III_RANHU("kapitan III ranhu"),
    KAPITAN_II_RANHU("kapitan II ranhu"),
    KAPITAN_I_RANHU("kapiatn I ranhu"),
    KOMODOR("kommodor"),
    KONTR_ADMIRAL("kontr-admiral"),
    VITSE_ADMIRAL("vitse-admiral"),
    ADMIRAL("admiral"),
    MATROS("matros"),
    STARSHYY_MATROS("starshyy matros"),
    STARSHYNA_2_OYI_STATTI("starshyna 2-oyi statti"),
    STARSHYNA_1_OYI_STATTI("starshyna 1-oyi statti"),
    HOLOVNYY_STARSHYNA("holovnyy starshyna"),
    HOLOVNYY_KORABELNYY_STARSHYNA("holovnyy korabel`nyy starshyna"),
    SHTAB_STARSHYNA("shtab-starshyna"),
    MAYSTER_STARSHYNA("mayster-starshyna"),
    STARSHYY_MAYSTER_STARSHYNA("starshyy mayster-starshyna"),
    HOLOVNYY_MAYSTER_STARSHYNA("holovnyy mayster starshyna");

    private final String rank;
}
