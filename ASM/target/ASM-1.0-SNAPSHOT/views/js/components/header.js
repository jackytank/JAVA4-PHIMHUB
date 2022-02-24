const headerTemplate = document.createElement("template");

headerTemplate.innerHTML = `
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<title>Phimkhongmoi</title>
<header>
<nav class="navbar is-light" role="navigation" aria-label="main navigation">
<div class="navbar-brand">
    <a href="" class="navbar-item">
        <img src="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" alt="">
    </a>
    <div class="navbar-item">
        <div class="control">
            <input type="text" class="input" placeholder="Search...">
        </div>
    </div>
    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false"
        data-target="navbarBasicExample">
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
    </a>
</div>
<div class="navbar-end">
    <a href="home.jsp" title="Log out" class="navbar-item">
        <span class="icon">
            <i class="fas fa-home"></i>
        </span>
        <span>HOME</span>
    </a>
    <a href="videos.jsp" title="Log out" class="navbar-item">
        <span class="icon">
            <i class="fas fa-video"></i>
        </span>
        <span>VIDEOS</span>
    </a>
    <a href="users.jsp" title="Log out" class="navbar-item">
        <span class="icon">
            <i class="fas fa-user-cog"></i>
        </span>
        <span>USERS</span>
    </a>
    <a href="reports.jsp" title="Log out" class="navbar-item">
        <span class="icon">
            <i class="fas fa-chart-bar"></i>
        </span>
        <span>REPORTS</span>
    </a>

    <a title="Log out" class="navbar-item">
        <span class="icon">
            <i class="fas fa-sign-out-alt"></i>
        </span>
        <span>Log out</span>
    </a>
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
