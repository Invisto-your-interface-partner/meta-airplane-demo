SUMMARY = "Qt5 filling line application"
DESCRIPTION = "Qt5 filling line application"
HOMEPAGE = "https://github.com/Invisto-your-interface-partner/DemoFillingLine"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PROVIDES += "filling-demo"

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

SRC_URI = "git://git@github.com/Invisto-your-interface-partner/DemoFillingLine.git;protocol=ssh;branch=main \
        file://filling-demo.service \
"

SRCREV = "35f3fff70296b438fbd1cbcbba010535e73a17fc"

S = "${WORKDIR}/git"

inherit qmake5 systemd

RDEPENDS:${PN} += "\
        qtsvg \
"

SYSTEMD_SERVICE_${PN} = "filling-demo.service"

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

#do_install:append() {
#        # Systemd
#        install -d ${D}${systemd_system_unitdir}
#        install -m 0644 ${WORKDIR}/filling-demo.service ${D}${systemd_system_unitdir}
#}

FILES:${PN} += " \
  ${bindir}/DemoAirplaneCockpit \
"

#FILES:${PN} += " \
#  ${bindir}/DemoFillingLine \
#  ${systemd_unitdir}/system/filling-demo.service \
#"

