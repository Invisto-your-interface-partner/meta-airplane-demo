SUMMARY = "Qt5 hyler application"
DESCRIPTION = "Qt5 hyler application"
HOMEPAGE = "https://github.com/Invisto-your-interface-partner/Hyler-HMI"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PROVIDES += "hyler-demo"

DEPENDS += "\
        qtbase \
        qtquickcontrols \
        qtquickcontrols2 \
        qtscxml \
        qtserialport \
        qtsvg \
        qttools-native \
        qttranslations \
"

PV = "1.0+git${SRCPV}"

SRC_URI = "git@github.com/Invisto-your-interface-partner/Hyler-HMI.git;protocol=ssh;branch=main \
        file://hyler-demo.service \
"

SRCREV = "b28ab95de70d59e920a61cf3acc7f190d4bc662e"

S = "${WORKDIR}/git"

inherit qmake5 systemd

RDEPENDS:${PN} += "\
        qtsvg \
"

SYSTEMD_SERVICE_${PN} = "hyler-demo.service"

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

#do_install:append() {
#        # Systemd
#        install -d ${D}${systemd_system_unitdir}
#        install -m 0644 ${WORKDIR}/filling-demo.service ${D}${systemd_system_unitdir}
#}

FILES:${PN} += " \
  ${bindir}/HylerHMI \
"

#FILES:${PN} += " \
#  ${bindir}/DemoFillingLine \
#  ${systemd_unitdir}/system/filling-demo.service \
#"

