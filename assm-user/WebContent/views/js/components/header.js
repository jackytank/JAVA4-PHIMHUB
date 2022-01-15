const headerTemplate = document.createElement('template');

headerTemplate.innerHTML = `
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<title>Phimkhongmoi</title>
<header>
<nav class="navbar is-light is-fixed-top" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a href="./index.jsp" class="navbar-item">
            <img src="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" alt="">
        </a>
        <a href="./index.jsp" class="navbar-item">PHIMKHONGMOI</a>
        <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="nav-bar"
            href="">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
        </a>
    </div>
    <div class="navbar-menu">
        <div class="navbar-end">
            <a href="./favorite.jsp" class="navbar-item">MY FAVORITES</a>
            <div class="navbar-item has-dropdown is-hoverable">
                <a href="" class="navbar-link">MY ACCOUNT</a>
                <div class="navbar-dropdown">
                    <a href="./login.jsp" class="navbar-item">LOGIN</a>
                    <a href="./forgotpassword.jsp" class="navbar-item">FORGOT PASSWORD</a>
                    <a href="./registration.jsp" class="navbar-item">REGISTRATION</a>
                    <a href="" class="navbar-item">LOGOFF</a>
                    <a href="./changepassword.jsp" class="navbar-item">CHANGE PASSWORD</a>
                    <a href="./editprofile.jsp" class="navbar-item">EDIT PROFILE</a>
                </div>
            </div>
        </div>
    </div>
</nav>
</header>
`;

class Header extends HTMLElement {
	constructor() {
		super();
	}

	connectedCallback() {
		const shadowRoot = this.attachShadow({ mode: `closed` });

		shadowRoot.appendChild(headerTemplate.content);
	}
}

customElements.define("header-component", Header);
